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

class AwsSnsSmsProviderConfigurationDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AwsSnsSmsProviderConfiguration#equals(Object)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
    int expectedHashCodeResult = awsSnsSmsProviderConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, awsSnsSmsProviderConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AwsSnsSmsProviderConfiguration#equals(Object)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId(null);
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId(null);
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
    int expectedHashCodeResult = awsSnsSmsProviderConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, awsSnsSmsProviderConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AwsSnsSmsProviderConfiguration#equals(Object)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion(null);
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion(null);
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
    int expectedHashCodeResult = awsSnsSmsProviderConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, awsSnsSmsProviderConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AwsSnsSmsProviderConfiguration#equals(Object)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey(null);

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey(null);

    // Act and Assert
    assertEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
    int expectedHashCodeResult = awsSnsSmsProviderConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, awsSnsSmsProviderConfiguration2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AwsSnsSmsProviderConfiguration#equals(Object)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration);
    int expectedHashCodeResult = awsSnsSmsProviderConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, awsSnsSmsProviderConfiguration.hashCode());
  }

  /**
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("42");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
  }

  /**
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId(null);
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
  }

  /**
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
  }

  /**
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion(null);
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
  }

  /**
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("us-east-2");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
  }

  /**
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey(null);

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
  }

  /**
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(awsSnsSmsProviderConfiguration, null);
  }

  /**
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration = new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(awsSnsSmsProviderConfiguration, "Different type to AwsSnsSmsProviderConfiguration");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link AwsSnsSmsProviderConfiguration}
   *   <li>{@link AwsSnsSmsProviderConfiguration#setAccessKeyId(String)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#setRegion(String)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#setSecretAccessKey(String)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#toString()}
   *   <li>{@link AwsSnsSmsProviderConfiguration#getAccessKeyId()}
   *   <li>{@link AwsSnsSmsProviderConfiguration#getRegion()}
   *   <li>{@link AwsSnsSmsProviderConfiguration#getSecretAccessKey()}
   *   <li>{@link AwsSnsSmsProviderConfiguration#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AwsSnsSmsProviderConfiguration actualAwsSnsSmsProviderConfiguration = new AwsSnsSmsProviderConfiguration();
    actualAwsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    actualAwsSnsSmsProviderConfiguration.setRegion("us-east-2");
    actualAwsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");
    String actualToStringResult = actualAwsSnsSmsProviderConfiguration.toString();
    String actualAccessKeyId = actualAwsSnsSmsProviderConfiguration.getAccessKeyId();
    String actualRegion = actualAwsSnsSmsProviderConfiguration.getRegion();
    String actualSecretAccessKey = actualAwsSnsSmsProviderConfiguration.getSecretAccessKey();

    // Assert that nothing has changed
    assertEquals(
        "AwsSnsSmsProviderConfiguration(accessKeyId=EXAMPLEakiAIOSFODNN7, secretAccessKey=EXAMPLEakiAIOSFODNN7,"
            + " region=us-east-2)",
        actualToStringResult);
    assertEquals("EXAMPLEakiAIOSFODNN7", actualAccessKeyId);
    assertEquals("EXAMPLEakiAIOSFODNN7", actualSecretAccessKey);
    assertEquals("us-east-2", actualRegion);
    assertEquals(SmsProviderType.AWS_SNS, actualAwsSnsSmsProviderConfiguration.getType());
  }
}
