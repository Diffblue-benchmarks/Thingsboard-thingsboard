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
package org.thingsboard.server.common.data.device.credentials;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class BasicMqttCredentialsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BasicMqttCredentials#equals(Object)}
   *   <li>{@link BasicMqttCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertEquals(basicMqttCredentials, basicMqttCredentials2);
    int expectedHashCodeResult = basicMqttCredentials.hashCode();
    assertEquals(expectedHashCodeResult, basicMqttCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BasicMqttCredentials#equals(Object)}
   *   <li>{@link BasicMqttCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId(null);
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId(null);
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertEquals(basicMqttCredentials, basicMqttCredentials2);
    int expectedHashCodeResult = basicMqttCredentials.hashCode();
    assertEquals(expectedHashCodeResult, basicMqttCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BasicMqttCredentials#equals(Object)}
   *   <li>{@link BasicMqttCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword(null);
    basicMqttCredentials.setUserName("janedoe");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword(null);
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertEquals(basicMqttCredentials, basicMqttCredentials2);
    int expectedHashCodeResult = basicMqttCredentials.hashCode();
    assertEquals(expectedHashCodeResult, basicMqttCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BasicMqttCredentials#equals(Object)}
   *   <li>{@link BasicMqttCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName(null);

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName(null);

    // Act and Assert
    assertEquals(basicMqttCredentials, basicMqttCredentials2);
    int expectedHashCodeResult = basicMqttCredentials.hashCode();
    assertEquals(expectedHashCodeResult, basicMqttCredentials2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BasicMqttCredentials#equals(Object)}
   *   <li>{@link BasicMqttCredentials#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");

    // Act and Assert
    assertEquals(basicMqttCredentials, basicMqttCredentials);
    int expectedHashCodeResult = basicMqttCredentials.hashCode();
    assertEquals(expectedHashCodeResult, basicMqttCredentials.hashCode());
  }

  /**
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("janedoe");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, basicMqttCredentials2);
  }

  /**
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId(null);
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, basicMqttCredentials2);
  }

  /**
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("42");
    basicMqttCredentials.setUserName("janedoe");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, basicMqttCredentials2);
  }

  /**
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword(null);
    basicMqttCredentials.setUserName("janedoe");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, basicMqttCredentials2);
  }

  /**
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("42");

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, basicMqttCredentials2);
  }

  /**
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName(null);

    BasicMqttCredentials basicMqttCredentials2 = new BasicMqttCredentials();
    basicMqttCredentials2.setClientId("42");
    basicMqttCredentials2.setPassword("iloveyou");
    basicMqttCredentials2.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, basicMqttCredentials2);
  }

  /**
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, null);
  }

  /**
   * Method under test: {@link BasicMqttCredentials#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    BasicMqttCredentials basicMqttCredentials = new BasicMqttCredentials();
    basicMqttCredentials.setClientId("42");
    basicMqttCredentials.setPassword("iloveyou");
    basicMqttCredentials.setUserName("janedoe");

    // Act and Assert
    assertNotEquals(basicMqttCredentials, "Different type to BasicMqttCredentials");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link BasicMqttCredentials}
   *   <li>{@link BasicMqttCredentials#setClientId(String)}
   *   <li>{@link BasicMqttCredentials#setPassword(String)}
   *   <li>{@link BasicMqttCredentials#setUserName(String)}
   *   <li>{@link BasicMqttCredentials#toString()}
   *   <li>{@link BasicMqttCredentials#getClientId()}
   *   <li>{@link BasicMqttCredentials#getPassword()}
   *   <li>{@link BasicMqttCredentials#getUserName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    BasicMqttCredentials actualBasicMqttCredentials = new BasicMqttCredentials();
    actualBasicMqttCredentials.setClientId("42");
    actualBasicMqttCredentials.setPassword("iloveyou");
    actualBasicMqttCredentials.setUserName("janedoe");
    String actualToStringResult = actualBasicMqttCredentials.toString();
    String actualClientId = actualBasicMqttCredentials.getClientId();
    String actualPassword = actualBasicMqttCredentials.getPassword();

    // Assert that nothing has changed
    assertEquals("42", actualClientId);
    assertEquals("BasicMqttCredentials(clientId=42, userName=janedoe, password=iloveyou)", actualToStringResult);
    assertEquals("iloveyou", actualPassword);
    assertEquals("janedoe", actualBasicMqttCredentials.getUserName());
  }
}
