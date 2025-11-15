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
package org.thingsboard.server.common.data.sms.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class TestSmsRequestDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TestSmsRequest#equals(Object)}
   *   <li>{@link TestSmsRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(null);

    // Act and Assert
    assertEquals(testSmsRequest, testSmsRequest2);
    int expectedHashCodeResult = testSmsRequest.hashCode();
    assertEquals(expectedHashCodeResult, testSmsRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TestSmsRequest#equals(Object)}
   *   <li>{@link TestSmsRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage(null);
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage(null);
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(null);

    // Act and Assert
    assertEquals(testSmsRequest, testSmsRequest2);
    int expectedHashCodeResult = testSmsRequest.hashCode();
    assertEquals(expectedHashCodeResult, testSmsRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TestSmsRequest#equals(Object)}
   *   <li>{@link TestSmsRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo(null);
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo(null);
    testSmsRequest2.setProviderConfiguration(null);

    // Act and Assert
    assertEquals(testSmsRequest, testSmsRequest2);
    int expectedHashCodeResult = testSmsRequest.hashCode();
    assertEquals(expectedHashCodeResult, testSmsRequest2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TestSmsRequest#equals(Object)}
   *   <li>{@link TestSmsRequest#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(mock(SmsProviderConfiguration.class));

    // Act and Assert
    assertEquals(testSmsRequest, testSmsRequest);
    int expectedHashCodeResult = testSmsRequest.hashCode();
    assertEquals(expectedHashCodeResult, testSmsRequest.hashCode());
  }

  /**
   * Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(mock(SmsProviderConfiguration.class));

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(mock(SmsProviderConfiguration.class));

    // Act and Assert
    assertNotEquals(testSmsRequest, testSmsRequest2);
  }

  /**
   * Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(mock(SmsProviderConfiguration.class));

    // Act and Assert
    assertNotEquals(testSmsRequest, testSmsRequest2);
  }

  /**
   * Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("42");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(null);

    // Act and Assert
    assertNotEquals(testSmsRequest, testSmsRequest2);
  }

  /**
   * Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage(null);
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(null);

    // Act and Assert
    assertNotEquals(testSmsRequest, testSmsRequest2);
  }

  /**
   * Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("alice.liddell@example.org");
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(null);

    // Act and Assert
    assertNotEquals(testSmsRequest, testSmsRequest2);
  }

  /**
   * Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo(null);
    testSmsRequest.setProviderConfiguration(null);

    TestSmsRequest testSmsRequest2 = new TestSmsRequest();
    testSmsRequest2.setMessage("Not all who wander are lost");
    testSmsRequest2.setNumberTo("42");
    testSmsRequest2.setProviderConfiguration(null);

    // Act and Assert
    assertNotEquals(testSmsRequest, testSmsRequest2);
  }

  /**
   * Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(mock(SmsProviderConfiguration.class));

    // Act and Assert
    assertNotEquals(testSmsRequest, null);
  }

  /**
   * Method under test: {@link TestSmsRequest#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TestSmsRequest testSmsRequest = new TestSmsRequest();
    testSmsRequest.setMessage("Not all who wander are lost");
    testSmsRequest.setNumberTo("42");
    testSmsRequest.setProviderConfiguration(mock(SmsProviderConfiguration.class));

    // Act and Assert
    assertNotEquals(testSmsRequest, "Different type to TestSmsRequest");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TestSmsRequest}
   *   <li>{@link TestSmsRequest#setMessage(String)}
   *   <li>{@link TestSmsRequest#setNumberTo(String)}
   *   <li>{@link TestSmsRequest#setProviderConfiguration(SmsProviderConfiguration)}
   *   <li>{@link TestSmsRequest#toString()}
   *   <li>{@link TestSmsRequest#getMessage()}
   *   <li>{@link TestSmsRequest#getNumberTo()}
   *   <li>{@link TestSmsRequest#getProviderConfiguration()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TestSmsRequest actualTestSmsRequest = new TestSmsRequest();
    actualTestSmsRequest.setMessage("Not all who wander are lost");
    actualTestSmsRequest.setNumberTo("42");
    SmsProviderConfiguration providerConfiguration = mock(SmsProviderConfiguration.class);
    actualTestSmsRequest.setProviderConfiguration(providerConfiguration);
    actualTestSmsRequest.toString();
    String actualMessage = actualTestSmsRequest.getMessage();
    String actualNumberTo = actualTestSmsRequest.getNumberTo();

    // Assert that nothing has changed
    assertEquals("42", actualNumberTo);
    assertEquals("Not all who wander are lost", actualMessage);
    assertSame(providerConfiguration, actualTestSmsRequest.getProviderConfiguration());
  }
}
