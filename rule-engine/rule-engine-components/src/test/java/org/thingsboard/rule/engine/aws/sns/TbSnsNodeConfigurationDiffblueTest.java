package org.thingsboard.rule.engine.aws.sns;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbSnsNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbSnsNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test: {@link TbSnsNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  void testDefaultConfiguration() {
    // Arrange and Act
    TbSnsNodeConfiguration actualDefaultConfigurationResult = (new TbSnsNodeConfiguration()).defaultConfiguration();

    // Assert
    assertEquals("arn:aws:sns:us-east-1:123456789012:MyNewTopic",
        actualDefaultConfigurationResult.getTopicArnPattern());
    assertEquals("us-east-1", actualDefaultConfigurationResult.getRegion());
    assertNull(actualDefaultConfigurationResult.getAccessKeyId());
    assertNull(actualDefaultConfigurationResult.getSecretAccessKey());
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}, and
   * {@link TbSnsNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSnsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSnsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();
    TbSnsNodeConfiguration tbSnsNodeConfiguration2 = new TbSnsNodeConfiguration();

    // Act and Assert
    assertEquals(tbSnsNodeConfiguration, tbSnsNodeConfiguration2);
    int expectedHashCodeResult = tbSnsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSnsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}, and
   * {@link TbSnsNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSnsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSnsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration.setTopicArnPattern("Topic Arn Pattern");

    TbSnsNodeConfiguration tbSnsNodeConfiguration2 = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration2.setTopicArnPattern("Topic Arn Pattern");

    // Act and Assert
    assertEquals(tbSnsNodeConfiguration, tbSnsNodeConfiguration2);
    int expectedHashCodeResult = tbSnsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSnsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}, and
   * {@link TbSnsNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSnsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSnsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");

    TbSnsNodeConfiguration tbSnsNodeConfiguration2 = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertEquals(tbSnsNodeConfiguration, tbSnsNodeConfiguration2);
    int expectedHashCodeResult = tbSnsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSnsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}, and
   * {@link TbSnsNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSnsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSnsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    TbSnsNodeConfiguration tbSnsNodeConfiguration2 = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertEquals(tbSnsNodeConfiguration, tbSnsNodeConfiguration2);
    int expectedHashCodeResult = tbSnsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSnsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}, and
   * {@link TbSnsNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSnsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSnsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration.setRegion("us-east-2");

    TbSnsNodeConfiguration tbSnsNodeConfiguration2 = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration2.setRegion("us-east-2");

    // Act and Assert
    assertEquals(tbSnsNodeConfiguration, tbSnsNodeConfiguration2);
    int expectedHashCodeResult = tbSnsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSnsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}, and
   * {@link TbSnsNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbSnsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSnsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();

    // Act and Assert
    assertEquals(tbSnsNodeConfiguration, tbSnsNodeConfiguration);
    int expectedHashCodeResult = tbSnsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSnsNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSnsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSnsNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSnsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration.setTopicArnPattern("Topic Arn Pattern");

    // Act and Assert
    assertNotEquals(tbSnsNodeConfiguration, new TbSnsNodeConfiguration());
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSnsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(tbSnsNodeConfiguration, new TbSnsNodeConfiguration());
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSnsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(tbSnsNodeConfiguration, new TbSnsNodeConfiguration());
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSnsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration.setRegion("us-east-2");

    // Act and Assert
    assertNotEquals(tbSnsNodeConfiguration, new TbSnsNodeConfiguration());
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSnsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();

    TbSnsNodeConfiguration tbSnsNodeConfiguration2 = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration2.setTopicArnPattern("Topic Arn Pattern");

    // Act and Assert
    assertNotEquals(tbSnsNodeConfiguration, tbSnsNodeConfiguration2);
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSnsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();

    TbSnsNodeConfiguration tbSnsNodeConfiguration2 = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(tbSnsNodeConfiguration, tbSnsNodeConfiguration2);
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSnsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();

    TbSnsNodeConfiguration tbSnsNodeConfiguration2 = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(tbSnsNodeConfiguration, tbSnsNodeConfiguration2);
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSnsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbSnsNodeConfiguration tbSnsNodeConfiguration = new TbSnsNodeConfiguration();

    TbSnsNodeConfiguration tbSnsNodeConfiguration2 = new TbSnsNodeConfiguration();
    tbSnsNodeConfiguration2.setRegion("us-east-2");

    // Act and Assert
    assertNotEquals(tbSnsNodeConfiguration, tbSnsNodeConfiguration2);
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSnsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSnsNodeConfiguration(), null);
  }

  /**
   * Test {@link TbSnsNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbSnsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSnsNodeConfiguration(), "Different type to TbSnsNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbSnsNodeConfiguration}
   *   <li>{@link TbSnsNodeConfiguration#setAccessKeyId(String)}
   *   <li>{@link TbSnsNodeConfiguration#setRegion(String)}
   *   <li>{@link TbSnsNodeConfiguration#setSecretAccessKey(String)}
   *   <li>{@link TbSnsNodeConfiguration#setTopicArnPattern(String)}
   *   <li>{@link TbSnsNodeConfiguration#toString()}
   *   <li>{@link TbSnsNodeConfiguration#getAccessKeyId()}
   *   <li>{@link TbSnsNodeConfiguration#getRegion()}
   *   <li>{@link TbSnsNodeConfiguration#getSecretAccessKey()}
   *   <li>{@link TbSnsNodeConfiguration#getTopicArnPattern()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbSnsNodeConfiguration actualTbSnsNodeConfiguration = new TbSnsNodeConfiguration();
    actualTbSnsNodeConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    actualTbSnsNodeConfiguration.setRegion("us-east-2");
    actualTbSnsNodeConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");
    actualTbSnsNodeConfiguration.setTopicArnPattern("Topic Arn Pattern");
    String actualToStringResult = actualTbSnsNodeConfiguration.toString();
    String actualAccessKeyId = actualTbSnsNodeConfiguration.getAccessKeyId();
    String actualRegion = actualTbSnsNodeConfiguration.getRegion();
    String actualSecretAccessKey = actualTbSnsNodeConfiguration.getSecretAccessKey();

    // Assert that nothing has changed
    assertEquals("EXAMPLEakiAIOSFODNN7", actualAccessKeyId);
    assertEquals("EXAMPLEakiAIOSFODNN7", actualSecretAccessKey);
    assertEquals("TbSnsNodeConfiguration(topicArnPattern=Topic Arn Pattern, accessKeyId=EXAMPLEakiAIOSFODNN7,"
        + " secretAccessKey=EXAMPLEakiAIOSFODNN7, region=us-east-2)", actualToStringResult);
    assertEquals("Topic Arn Pattern", actualTbSnsNodeConfiguration.getTopicArnPattern());
    assertEquals("us-east-2", actualRegion);
  }
}
