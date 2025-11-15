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
package org.thingsboard.server.common.data.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class ToDeviceRpcRequestBodyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToDeviceRpcRequestBody#equals(Object)}
   *   <li>{@link ToDeviceRpcRequestBody#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody("Method", "Params");
    ToDeviceRpcRequestBody toDeviceRpcRequestBody2 = new ToDeviceRpcRequestBody("Method", "Params");

    // Act and Assert
    assertEquals(toDeviceRpcRequestBody, toDeviceRpcRequestBody2);
    int expectedHashCodeResult = toDeviceRpcRequestBody.hashCode();
    assertEquals(expectedHashCodeResult, toDeviceRpcRequestBody2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToDeviceRpcRequestBody#equals(Object)}
   *   <li>{@link ToDeviceRpcRequestBody#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody(null, "Params");
    ToDeviceRpcRequestBody toDeviceRpcRequestBody2 = new ToDeviceRpcRequestBody(null, "Params");

    // Act and Assert
    assertEquals(toDeviceRpcRequestBody, toDeviceRpcRequestBody2);
    int expectedHashCodeResult = toDeviceRpcRequestBody.hashCode();
    assertEquals(expectedHashCodeResult, toDeviceRpcRequestBody2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToDeviceRpcRequestBody#equals(Object)}
   *   <li>{@link ToDeviceRpcRequestBody#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody("Method", null);
    ToDeviceRpcRequestBody toDeviceRpcRequestBody2 = new ToDeviceRpcRequestBody("Method", null);

    // Act and Assert
    assertEquals(toDeviceRpcRequestBody, toDeviceRpcRequestBody2);
    int expectedHashCodeResult = toDeviceRpcRequestBody.hashCode();
    assertEquals(expectedHashCodeResult, toDeviceRpcRequestBody2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToDeviceRpcRequestBody#equals(Object)}
   *   <li>{@link ToDeviceRpcRequestBody#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody("Method", "Params");

    // Act and Assert
    assertEquals(toDeviceRpcRequestBody, toDeviceRpcRequestBody);
    int expectedHashCodeResult = toDeviceRpcRequestBody.hashCode();
    assertEquals(expectedHashCodeResult, toDeviceRpcRequestBody.hashCode());
  }

  /**
   * Method under test: {@link ToDeviceRpcRequestBody#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody("Params", "Params");

    // Act and Assert
    assertNotEquals(toDeviceRpcRequestBody, new ToDeviceRpcRequestBody("Method", "Params"));
  }

  /**
   * Method under test: {@link ToDeviceRpcRequestBody#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody(null, "Params");

    // Act and Assert
    assertNotEquals(toDeviceRpcRequestBody, new ToDeviceRpcRequestBody("Method", "Params"));
  }

  /**
   * Method under test: {@link ToDeviceRpcRequestBody#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody("Method", "Method");

    // Act and Assert
    assertNotEquals(toDeviceRpcRequestBody, new ToDeviceRpcRequestBody("Method", "Params"));
  }

  /**
   * Method under test: {@link ToDeviceRpcRequestBody#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ToDeviceRpcRequestBody toDeviceRpcRequestBody = new ToDeviceRpcRequestBody("Method", null);

    // Act and Assert
    assertNotEquals(toDeviceRpcRequestBody, new ToDeviceRpcRequestBody("Method", "Params"));
  }

  /**
   * Method under test: {@link ToDeviceRpcRequestBody#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ToDeviceRpcRequestBody("Method", "Params"), null);
  }

  /**
   * Method under test: {@link ToDeviceRpcRequestBody#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ToDeviceRpcRequestBody("Method", "Params"), "Different type to ToDeviceRpcRequestBody");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ToDeviceRpcRequestBody#ToDeviceRpcRequestBody(String, String)}
   *   <li>{@link ToDeviceRpcRequestBody#toString()}
   *   <li>{@link ToDeviceRpcRequestBody#getMethod()}
   *   <li>{@link ToDeviceRpcRequestBody#getParams()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ToDeviceRpcRequestBody actualToDeviceRpcRequestBody = new ToDeviceRpcRequestBody("Method", "Params");
    String actualToStringResult = actualToDeviceRpcRequestBody.toString();
    String actualMethod = actualToDeviceRpcRequestBody.getMethod();

    // Assert
    assertEquals("Method", actualMethod);
    assertEquals("Params", actualToDeviceRpcRequestBody.getParams());
    assertEquals("ToDeviceRpcRequestBody(method=Method, params=Params)", actualToStringResult);
  }
}
