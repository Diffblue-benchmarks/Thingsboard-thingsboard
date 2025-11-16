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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AwsSnsSmsProviderConfigurationDiffblueTest {
  /**
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}, and {@link
   * AwsSnsSmsProviderConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AwsSnsSmsProviderConfiguration#equals(Object)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSnsSmsProviderConfiguration.equals(Object)",
    "int AwsSnsSmsProviderConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
    assertEquals(
        awsSnsSmsProviderConfiguration.hashCode(), awsSnsSmsProviderConfiguration2.hashCode());
  }

  /**
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}, and {@link
   * AwsSnsSmsProviderConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AwsSnsSmsProviderConfiguration#equals(Object)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSnsSmsProviderConfiguration.equals(Object)",
    "int AwsSnsSmsProviderConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId(null);
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId(null);
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
    assertEquals(
        awsSnsSmsProviderConfiguration.hashCode(), awsSnsSmsProviderConfiguration2.hashCode());
  }

  /**
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}, and {@link
   * AwsSnsSmsProviderConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AwsSnsSmsProviderConfiguration#equals(Object)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSnsSmsProviderConfiguration.equals(Object)",
    "int AwsSnsSmsProviderConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion(null);
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion(null);
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
    assertEquals(
        awsSnsSmsProviderConfiguration.hashCode(), awsSnsSmsProviderConfiguration2.hashCode());
  }

  /**
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}, and {@link
   * AwsSnsSmsProviderConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AwsSnsSmsProviderConfiguration#equals(Object)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSnsSmsProviderConfiguration.equals(Object)",
    "int AwsSnsSmsProviderConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey(null);

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey(null);

    // Act and Assert
    assertEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
    assertEquals(
        awsSnsSmsProviderConfiguration.hashCode(), awsSnsSmsProviderConfiguration2.hashCode());
  }

  /**
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}, and {@link
   * AwsSnsSmsProviderConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AwsSnsSmsProviderConfiguration#equals(Object)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSnsSmsProviderConfiguration.equals(Object)",
    "int AwsSnsSmsProviderConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration);
    int expectedHashCodeResult = awsSnsSmsProviderConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, awsSnsSmsProviderConfiguration.hashCode());
  }

  /**
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSnsSmsProviderConfiguration.equals(Object)",
    "int AwsSnsSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("42");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
  }

  /**
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSnsSmsProviderConfiguration.equals(Object)",
    "int AwsSnsSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId(null);
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
  }

  /**
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSnsSmsProviderConfiguration.equals(Object)",
    "int AwsSnsSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
  }

  /**
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSnsSmsProviderConfiguration.equals(Object)",
    "int AwsSnsSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion(null);
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
  }

  /**
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSnsSmsProviderConfiguration.equals(Object)",
    "int AwsSnsSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("us-east-2");

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
  }

  /**
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSnsSmsProviderConfiguration.equals(Object)",
    "int AwsSnsSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey(null);

    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration2 =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration2.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(awsSnsSmsProviderConfiguration, awsSnsSmsProviderConfiguration2);
  }

  /**
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSnsSmsProviderConfiguration.equals(Object)",
    "int AwsSnsSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(awsSnsSmsProviderConfiguration, null);
  }

  /**
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AwsSnsSmsProviderConfiguration.equals(Object)",
    "int AwsSnsSmsProviderConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration =
        new AwsSnsSmsProviderConfiguration();
    awsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    awsSnsSmsProviderConfiguration.setRegion("us-east-2");
    awsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(
        awsSnsSmsProviderConfiguration, "Different type to AwsSnsSmsProviderConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link AwsSnsSmsProviderConfiguration}
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AwsSnsSmsProviderConfiguration.<init>()",
    "String AwsSnsSmsProviderConfiguration.getAccessKeyId()",
    "String AwsSnsSmsProviderConfiguration.getRegion()",
    "String AwsSnsSmsProviderConfiguration.getSecretAccessKey()",
    "SmsProviderType AwsSnsSmsProviderConfiguration.getType()",
    "void AwsSnsSmsProviderConfiguration.setAccessKeyId(String)",
    "void AwsSnsSmsProviderConfiguration.setRegion(String)",
    "void AwsSnsSmsProviderConfiguration.setSecretAccessKey(String)",
    "String AwsSnsSmsProviderConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    AwsSnsSmsProviderConfiguration actualAwsSnsSmsProviderConfiguration =
        new AwsSnsSmsProviderConfiguration();
    actualAwsSnsSmsProviderConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    actualAwsSnsSmsProviderConfiguration.setRegion("us-east-2");
    actualAwsSnsSmsProviderConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");
    String actualToStringResult = actualAwsSnsSmsProviderConfiguration.toString();
    String actualAccessKeyId = actualAwsSnsSmsProviderConfiguration.getAccessKeyId();
    String actualRegion = actualAwsSnsSmsProviderConfiguration.getRegion();
    String actualSecretAccessKey = actualAwsSnsSmsProviderConfiguration.getSecretAccessKey();

    // Assert
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
