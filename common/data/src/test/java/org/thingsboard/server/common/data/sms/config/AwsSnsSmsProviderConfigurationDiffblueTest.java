package org.thingsboard.server.common.data.sms.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AwsSnsSmsProviderConfigurationDiffblueTest {
  /**
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}, and
   * {@link AwsSnsSmsProviderConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AwsSnsSmsProviderConfiguration#equals(Object)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}, and
   * {@link AwsSnsSmsProviderConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AwsSnsSmsProviderConfiguration#equals(Object)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}, and
   * {@link AwsSnsSmsProviderConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AwsSnsSmsProviderConfiguration#equals(Object)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}, and
   * {@link AwsSnsSmsProviderConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AwsSnsSmsProviderConfiguration#equals(Object)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
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
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}, and
   * {@link AwsSnsSmsProviderConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AwsSnsSmsProviderConfiguration#equals(Object)}
   *   <li>{@link AwsSnsSmsProviderConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
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
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
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
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
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
   * Test {@link AwsSnsSmsProviderConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSnsSmsProviderConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
