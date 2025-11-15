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
import org.junit.jupiter.api.Test;

class TwilioSmsProviderConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TwilioSmsProviderConfiguration#equals(Object)}
   *   <li>{@link TwilioSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
    int expectedHashCodeResult = twilioSmsProviderConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, twilioSmsProviderConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TwilioSmsProviderConfiguration#equals(Object)}
   *   <li>{@link TwilioSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid(null);
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid(null);
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
    int expectedHashCodeResult = twilioSmsProviderConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, twilioSmsProviderConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TwilioSmsProviderConfiguration#equals(Object)}
   *   <li>{@link TwilioSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken(null);
    twilioSmsProviderConfiguration.setNumberFrom("42");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken(null);
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
    int expectedHashCodeResult = twilioSmsProviderConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, twilioSmsProviderConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TwilioSmsProviderConfiguration#equals(Object)}
   *   <li>{@link TwilioSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom(null);

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom(null);

    // Act and Assert
    assertEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
    int expectedHashCodeResult = twilioSmsProviderConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, twilioSmsProviderConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TwilioSmsProviderConfiguration#equals(Object)}
   *   <li>{@link TwilioSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    // Act and Assert
    assertEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration);
    int expectedHashCodeResult = twilioSmsProviderConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, twilioSmsProviderConfiguration.hashCode());
  }

  /**
   * Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("ABC123");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
  }

  /**
   * Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid(null);
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
  }

  /**
   * Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("3");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
  }

  /**
   * Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken(null);
    twilioSmsProviderConfiguration.setNumberFrom("42");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
  }

  /**
   * Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("jane.doe@example.org");

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
  }

  /**
   * Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom(null);

    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration2 = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration2.setAccountSid("3");
    twilioSmsProviderConfiguration2.setAccountToken("ABC123");
    twilioSmsProviderConfiguration2.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(twilioSmsProviderConfiguration, twilioSmsProviderConfiguration2);
  }

  /**
   * Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(twilioSmsProviderConfiguration, null);
  }

  /**
   * Method under test: {@link TwilioSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TwilioSmsProviderConfiguration twilioSmsProviderConfiguration = new TwilioSmsProviderConfiguration();
    twilioSmsProviderConfiguration.setAccountSid("3");
    twilioSmsProviderConfiguration.setAccountToken("ABC123");
    twilioSmsProviderConfiguration.setNumberFrom("42");

    // Act and Assert
    assertNotEquals(twilioSmsProviderConfiguration, "Different type to TwilioSmsProviderConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TwilioSmsProviderConfiguration}
   *   <li>{@link TwilioSmsProviderConfiguration#setAccountSid(String)}
   *   <li>{@link TwilioSmsProviderConfiguration#setAccountToken(String)}
   *   <li>{@link TwilioSmsProviderConfiguration#setNumberFrom(String)}
   *   <li>{@link TwilioSmsProviderConfiguration#toString()}
   *   <li>{@link TwilioSmsProviderConfiguration#getAccountSid()}
   *   <li>{@link TwilioSmsProviderConfiguration#getAccountToken()}
   *   <li>{@link TwilioSmsProviderConfiguration#getNumberFrom()}
   *   <li>{@link TwilioSmsProviderConfiguration#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TwilioSmsProviderConfiguration actualTwilioSmsProviderConfiguration = new TwilioSmsProviderConfiguration();
    actualTwilioSmsProviderConfiguration.setAccountSid("3");
    actualTwilioSmsProviderConfiguration.setAccountToken("ABC123");
    actualTwilioSmsProviderConfiguration.setNumberFrom("42");
    String actualToStringResult = actualTwilioSmsProviderConfiguration.toString();
    String actualAccountSid = actualTwilioSmsProviderConfiguration.getAccountSid();
    String actualAccountToken = actualTwilioSmsProviderConfiguration.getAccountToken();
    String actualNumberFrom = actualTwilioSmsProviderConfiguration.getNumberFrom();

    // Assert that nothing has changed
    assertEquals("3", actualAccountSid);
    assertEquals("42", actualNumberFrom);
    assertEquals("ABC123", actualAccountToken);
    assertEquals("TwilioSmsProviderConfiguration(accountSid=3, accountToken=ABC123, numberFrom=42)",
        actualToStringResult);
    assertEquals(SmsProviderType.TWILIO, actualTwilioSmsProviderConfiguration.getType());
  }
}
