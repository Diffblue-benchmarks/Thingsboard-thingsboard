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
package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ErrorEventFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorEventFilter#equals(Object)}
   *   <li>{@link ErrorEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Server");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(errorEventFilter, errorEventFilter2);
    int expectedHashCodeResult = errorEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, errorEventFilter2.hashCode());
  }

  /**
   * Method under test: {@link ErrorEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty() {
    // Arrange, Act and Assert
    assertFalse((new ErrorEventFilter()).isNotEmpty());
  }

  /**
   * Method under test: {@link ErrorEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty2() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr(null);
    errorEventFilter.setServer(null);
    errorEventFilter.setMethod("");

    // Act and Assert
    assertFalse(errorEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link ErrorEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty3() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr(null);
    errorEventFilter.setServer(null);
    errorEventFilter.setMethod("foo");

    // Act and Assert
    assertTrue(errorEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link ErrorEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty4() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr(null);
    errorEventFilter.setServer("foo");
    errorEventFilter.setMethod(null);

    // Act and Assert
    assertTrue(errorEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link ErrorEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty5() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("foo");
    errorEventFilter.setServer(null);
    errorEventFilter.setMethod(null);

    // Act and Assert
    assertTrue(errorEventFilter.isNotEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorEventFilter#equals(Object)}
   *   <li>{@link ErrorEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr(null);
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Server");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr(null);
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(errorEventFilter, errorEventFilter2);
    int expectedHashCodeResult = errorEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, errorEventFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorEventFilter#equals(Object)}
   *   <li>{@link ErrorEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod(null);
    errorEventFilter.setServer("Server");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod(null);
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(errorEventFilter, errorEventFilter2);
    int expectedHashCodeResult = errorEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, errorEventFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorEventFilter#equals(Object)}
   *   <li>{@link ErrorEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer(null);

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer(null);

    // Act and Assert
    assertEquals(errorEventFilter, errorEventFilter2);
    int expectedHashCodeResult = errorEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, errorEventFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ErrorEventFilter#equals(Object)}
   *   <li>{@link ErrorEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Server");

    // Act and Assert
    assertEquals(errorEventFilter, errorEventFilter);
    int expectedHashCodeResult = errorEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, errorEventFilter.hashCode());
  }

  /**
   * Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("Server");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Server");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, errorEventFilter2);
  }

  /**
   * Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr(null);
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Server");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, errorEventFilter2);
  }

  /**
   * Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Server");
    errorEventFilter.setServer("Server");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, errorEventFilter2);
  }

  /**
   * Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod(null);
    errorEventFilter.setServer("Server");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, errorEventFilter2);
  }

  /**
   * Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Method");

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, errorEventFilter2);
  }

  /**
   * Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer(null);

    ErrorEventFilter errorEventFilter2 = new ErrorEventFilter();
    errorEventFilter2.setErrorStr("An error occurred");
    errorEventFilter2.setMethod("Method");
    errorEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, errorEventFilter2);
  }

  /**
   * Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, null);
  }

  /**
   * Method under test: {@link ErrorEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ErrorEventFilter errorEventFilter = new ErrorEventFilter();
    errorEventFilter.setErrorStr("An error occurred");
    errorEventFilter.setMethod("Method");
    errorEventFilter.setServer("Server");

    // Act and Assert
    assertNotEquals(errorEventFilter, "Different type to ErrorEventFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ErrorEventFilter}
   *   <li>{@link ErrorEventFilter#setErrorStr(String)}
   *   <li>{@link ErrorEventFilter#setMethod(String)}
   *   <li>{@link ErrorEventFilter#setServer(String)}
   *   <li>{@link ErrorEventFilter#toString()}
   *   <li>{@link ErrorEventFilter#getErrorStr()}
   *   <li>{@link ErrorEventFilter#getEventType()}
   *   <li>{@link ErrorEventFilter#getMethod()}
   *   <li>{@link ErrorEventFilter#getServer()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ErrorEventFilter actualErrorEventFilter = new ErrorEventFilter();
    actualErrorEventFilter.setErrorStr("An error occurred");
    actualErrorEventFilter.setMethod("Method");
    actualErrorEventFilter.setServer("Server");
    String actualToStringResult = actualErrorEventFilter.toString();
    String actualErrorStr = actualErrorEventFilter.getErrorStr();
    EventType actualEventType = actualErrorEventFilter.getEventType();
    String actualMethod = actualErrorEventFilter.getMethod();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualErrorStr);
    assertEquals("ErrorEventFilter(server=Server, method=Method, errorStr=An error occurred)", actualToStringResult);
    assertEquals("Method", actualMethod);
    assertEquals("Server", actualErrorEventFilter.getServer());
    assertEquals(EventType.ERROR, actualEventType);
  }
}
