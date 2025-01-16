package org.thingsboard.rule.engine.aws.lambda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbAwsLambdaNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbAwsLambdaNodeConfiguration#defaultConfiguration()}.
   * <p>
   * Method under test:
   * {@link TbAwsLambdaNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  void testDefaultConfiguration() {
    // Arrange and Act
    TbAwsLambdaNodeConfiguration actualDefaultConfigurationResult = (new TbAwsLambdaNodeConfiguration())
        .defaultConfiguration();

    // Assert
    assertEquals("us-east-1", actualDefaultConfigurationResult.getRegion());
    assertNull(actualDefaultConfigurationResult.getAccessKey());
    assertNull(actualDefaultConfigurationResult.getFunctionName());
    assertNull(actualDefaultConfigurationResult.getSecretKey());
    assertEquals(10, actualDefaultConfigurationResult.getConnectionTimeout());
    assertEquals(5, actualDefaultConfigurationResult.getRequestTimeout());
    assertFalse(actualDefaultConfigurationResult.isTellFailureIfFuncThrowsExc());
    assertEquals(TbAwsLambdaNodeConfiguration.DEFAULT_QUALIFIER, actualDefaultConfigurationResult.getQualifier());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}, and
   * {@link TbAwsLambdaNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbAwsLambdaNodeConfiguration#equals(Object)}
   *   <li>{@link TbAwsLambdaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration2 = new TbAwsLambdaNodeConfiguration();

    // Act and Assert
    assertEquals(tbAwsLambdaNodeConfiguration, tbAwsLambdaNodeConfiguration2);
    int expectedHashCodeResult = tbAwsLambdaNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbAwsLambdaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}, and
   * {@link TbAwsLambdaNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbAwsLambdaNodeConfiguration#equals(Object)}
   *   <li>{@link TbAwsLambdaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration.setAccessKey("EXAMPLEakiAIOSFODNN7");

    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration2 = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration2.setAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertEquals(tbAwsLambdaNodeConfiguration, tbAwsLambdaNodeConfiguration2);
    int expectedHashCodeResult = tbAwsLambdaNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbAwsLambdaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}, and
   * {@link TbAwsLambdaNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbAwsLambdaNodeConfiguration#equals(Object)}
   *   <li>{@link TbAwsLambdaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration.setSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration2 = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration2.setSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Act and Assert
    assertEquals(tbAwsLambdaNodeConfiguration, tbAwsLambdaNodeConfiguration2);
    int expectedHashCodeResult = tbAwsLambdaNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbAwsLambdaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}, and
   * {@link TbAwsLambdaNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbAwsLambdaNodeConfiguration#equals(Object)}
   *   <li>{@link TbAwsLambdaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration.setRegion("us-east-2");

    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration2 = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration2.setRegion("us-east-2");

    // Act and Assert
    assertEquals(tbAwsLambdaNodeConfiguration, tbAwsLambdaNodeConfiguration2);
    int expectedHashCodeResult = tbAwsLambdaNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbAwsLambdaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}, and
   * {@link TbAwsLambdaNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbAwsLambdaNodeConfiguration#equals(Object)}
   *   <li>{@link TbAwsLambdaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration.setFunctionName("Function Name");

    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration2 = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration2.setFunctionName("Function Name");

    // Act and Assert
    assertEquals(tbAwsLambdaNodeConfiguration, tbAwsLambdaNodeConfiguration2);
    int expectedHashCodeResult = tbAwsLambdaNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbAwsLambdaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}, and
   * {@link TbAwsLambdaNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbAwsLambdaNodeConfiguration#equals(Object)}
   *   <li>{@link TbAwsLambdaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration.setQualifier("Qualifier");

    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration2 = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration2.setQualifier("Qualifier");

    // Act and Assert
    assertEquals(tbAwsLambdaNodeConfiguration, tbAwsLambdaNodeConfiguration2);
    int expectedHashCodeResult = tbAwsLambdaNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbAwsLambdaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}, and
   * {@link TbAwsLambdaNodeConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbAwsLambdaNodeConfiguration#equals(Object)}
   *   <li>{@link TbAwsLambdaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();

    // Act and Assert
    assertEquals(tbAwsLambdaNodeConfiguration, tbAwsLambdaNodeConfiguration);
    int expectedHashCodeResult = tbAwsLambdaNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbAwsLambdaNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbAwsLambdaNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration.setAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(tbAwsLambdaNodeConfiguration, new TbAwsLambdaNodeConfiguration());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration.setSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Act and Assert
    assertNotEquals(tbAwsLambdaNodeConfiguration, new TbAwsLambdaNodeConfiguration());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration.setRegion("us-east-2");

    // Act and Assert
    assertNotEquals(tbAwsLambdaNodeConfiguration, new TbAwsLambdaNodeConfiguration());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration.setFunctionName("Function Name");

    // Act and Assert
    assertNotEquals(tbAwsLambdaNodeConfiguration, new TbAwsLambdaNodeConfiguration());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration.setQualifier("Qualifier");

    // Act and Assert
    assertNotEquals(tbAwsLambdaNodeConfiguration, new TbAwsLambdaNodeConfiguration());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration.setConnectionTimeout(10);

    // Act and Assert
    assertNotEquals(tbAwsLambdaNodeConfiguration, new TbAwsLambdaNodeConfiguration());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration.setRequestTimeout(10);

    // Act and Assert
    assertNotEquals(tbAwsLambdaNodeConfiguration, new TbAwsLambdaNodeConfiguration());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration.setTellFailureIfFuncThrowsExc(true);

    // Act and Assert
    assertNotEquals(tbAwsLambdaNodeConfiguration, new TbAwsLambdaNodeConfiguration());
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();

    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration2 = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration2.setAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(tbAwsLambdaNodeConfiguration, tbAwsLambdaNodeConfiguration2);
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();

    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration2 = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration2.setSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");

    // Act and Assert
    assertNotEquals(tbAwsLambdaNodeConfiguration, tbAwsLambdaNodeConfiguration2);
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();

    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration2 = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration2.setRegion("us-east-2");

    // Act and Assert
    assertNotEquals(tbAwsLambdaNodeConfiguration, tbAwsLambdaNodeConfiguration2);
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();

    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration2 = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration2.setFunctionName("Function Name");

    // Act and Assert
    assertNotEquals(tbAwsLambdaNodeConfiguration, tbAwsLambdaNodeConfiguration2);
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();

    TbAwsLambdaNodeConfiguration tbAwsLambdaNodeConfiguration2 = new TbAwsLambdaNodeConfiguration();
    tbAwsLambdaNodeConfiguration2.setQualifier("Qualifier");

    // Act and Assert
    assertNotEquals(tbAwsLambdaNodeConfiguration, tbAwsLambdaNodeConfiguration2);
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbAwsLambdaNodeConfiguration(), null);
  }

  /**
   * Test {@link TbAwsLambdaNodeConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbAwsLambdaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbAwsLambdaNodeConfiguration(), "Different type to TbAwsLambdaNodeConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbAwsLambdaNodeConfiguration}
   *   <li>{@link TbAwsLambdaNodeConfiguration#setAccessKey(String)}
   *   <li>{@link TbAwsLambdaNodeConfiguration#setConnectionTimeout(int)}
   *   <li>{@link TbAwsLambdaNodeConfiguration#setFunctionName(String)}
   *   <li>{@link TbAwsLambdaNodeConfiguration#setQualifier(String)}
   *   <li>{@link TbAwsLambdaNodeConfiguration#setRegion(String)}
   *   <li>{@link TbAwsLambdaNodeConfiguration#setRequestTimeout(int)}
   *   <li>{@link TbAwsLambdaNodeConfiguration#setSecretKey(String)}
   *   <li>
   * {@link TbAwsLambdaNodeConfiguration#setTellFailureIfFuncThrowsExc(boolean)}
   *   <li>{@link TbAwsLambdaNodeConfiguration#toString()}
   *   <li>{@link TbAwsLambdaNodeConfiguration#getAccessKey()}
   *   <li>{@link TbAwsLambdaNodeConfiguration#getConnectionTimeout()}
   *   <li>{@link TbAwsLambdaNodeConfiguration#getFunctionName()}
   *   <li>{@link TbAwsLambdaNodeConfiguration#getQualifier()}
   *   <li>{@link TbAwsLambdaNodeConfiguration#getRegion()}
   *   <li>{@link TbAwsLambdaNodeConfiguration#getRequestTimeout()}
   *   <li>{@link TbAwsLambdaNodeConfiguration#getSecretKey()}
   *   <li>{@link TbAwsLambdaNodeConfiguration#isTellFailureIfFuncThrowsExc()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    TbAwsLambdaNodeConfiguration actualTbAwsLambdaNodeConfiguration = new TbAwsLambdaNodeConfiguration();
    actualTbAwsLambdaNodeConfiguration.setAccessKey("EXAMPLEakiAIOSFODNN7");
    actualTbAwsLambdaNodeConfiguration.setConnectionTimeout(10);
    actualTbAwsLambdaNodeConfiguration.setFunctionName("Function Name");
    actualTbAwsLambdaNodeConfiguration.setQualifier("Qualifier");
    actualTbAwsLambdaNodeConfiguration.setRegion("us-east-2");
    actualTbAwsLambdaNodeConfiguration.setRequestTimeout(10);
    actualTbAwsLambdaNodeConfiguration.setSecretKey("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY");
    actualTbAwsLambdaNodeConfiguration.setTellFailureIfFuncThrowsExc(true);
    String actualToStringResult = actualTbAwsLambdaNodeConfiguration.toString();
    String actualAccessKey = actualTbAwsLambdaNodeConfiguration.getAccessKey();
    int actualConnectionTimeout = actualTbAwsLambdaNodeConfiguration.getConnectionTimeout();
    String actualFunctionName = actualTbAwsLambdaNodeConfiguration.getFunctionName();
    String actualQualifier = actualTbAwsLambdaNodeConfiguration.getQualifier();
    String actualRegion = actualTbAwsLambdaNodeConfiguration.getRegion();
    int actualRequestTimeout = actualTbAwsLambdaNodeConfiguration.getRequestTimeout();
    String actualSecretKey = actualTbAwsLambdaNodeConfiguration.getSecretKey();

    // Assert that nothing has changed
    assertEquals("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", actualSecretKey);
    assertEquals("EXAMPLEakiAIOSFODNN7", actualAccessKey);
    assertEquals("Function Name", actualFunctionName);
    assertEquals("Qualifier", actualQualifier);
    assertEquals(
        "TbAwsLambdaNodeConfiguration(accessKey=EXAMPLEakiAIOSFODNN7, secretKey=EXAMPLEKEYwjalrXUtnFEMI/K7MDENG"
            + "/bPxRfiCY, region=us-east-2, functionName=Function Name, qualifier=Qualifier, connectionTimeout=10,"
            + " requestTimeout=10, tellFailureIfFuncThrowsExc=true)",
        actualToStringResult);
    assertEquals("us-east-2", actualRegion);
    assertEquals(10, actualConnectionTimeout);
    assertEquals(10, actualRequestTimeout);
    assertTrue(actualTbAwsLambdaNodeConfiguration.isTellFailureIfFuncThrowsExc());
  }
}
