package org.thingsboard.rule.engine.aws.sqs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.aws.sqs.TbSqsNodeConfiguration.QueueType;

class TbSqsNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbSqsNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"TbSqsNodeConfiguration TbSqsNodeConfiguration.defaultConfiguration()"})
  void testDefaultConfiguration() {
    // Arrange and Act
    TbSqsNodeConfiguration actualDefaultConfigurationResult =
        new TbSqsNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals(
        "https://sqs.us-east-1.amazonaws.com/123456789012/my-queue-name",
        actualDefaultConfigurationResult.getQueueUrlPattern());
    assertEquals("us-east-1", actualDefaultConfigurationResult.getRegion());
    assertNull(actualDefaultConfigurationResult.getAccessKeyId());
    assertNull(actualDefaultConfigurationResult.getSecretAccessKey());
    assertEquals(0, actualDefaultConfigurationResult.getDelaySeconds());
    assertEquals(QueueType.STANDARD, actualDefaultConfigurationResult.getQueueType());
    assertTrue(actualDefaultConfigurationResult.getMessageAttributes().isEmpty());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}, and {@link
   * TbSqsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSqsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSqsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();
    TbSqsNodeConfiguration tbSqsNodeConfiguration2 = new TbSqsNodeConfiguration();

    // Act and Assert
    assertEquals(tbSqsNodeConfiguration, tbSqsNodeConfiguration2);
    int expectedHashCodeResult = tbSqsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSqsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}, and {@link
   * TbSqsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSqsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSqsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration.setQueueType(QueueType.STANDARD);

    TbSqsNodeConfiguration tbSqsNodeConfiguration2 = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration2.setQueueType(QueueType.STANDARD);

    // Act and Assert
    assertEquals(tbSqsNodeConfiguration, tbSqsNodeConfiguration2);
    int expectedHashCodeResult = tbSqsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSqsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}, and {@link
   * TbSqsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSqsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSqsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration.setQueueUrlPattern("https://example.org/example");

    TbSqsNodeConfiguration tbSqsNodeConfiguration2 = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration2.setQueueUrlPattern("https://example.org/example");

    // Act and Assert
    assertEquals(tbSqsNodeConfiguration, tbSqsNodeConfiguration2);
    int expectedHashCodeResult = tbSqsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSqsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}, and {@link
   * TbSqsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSqsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSqsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration.setMessageAttributes(new HashMap<>());

    TbSqsNodeConfiguration tbSqsNodeConfiguration2 = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration2.setMessageAttributes(new HashMap<>());

    // Act and Assert
    assertEquals(tbSqsNodeConfiguration, tbSqsNodeConfiguration2);
    int expectedHashCodeResult = tbSqsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSqsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}, and {@link
   * TbSqsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSqsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSqsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");

    TbSqsNodeConfiguration tbSqsNodeConfiguration2 = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertEquals(tbSqsNodeConfiguration, tbSqsNodeConfiguration2);
    int expectedHashCodeResult = tbSqsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSqsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}, and {@link
   * TbSqsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSqsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSqsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    TbSqsNodeConfiguration tbSqsNodeConfiguration2 = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertEquals(tbSqsNodeConfiguration, tbSqsNodeConfiguration2);
    int expectedHashCodeResult = tbSqsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSqsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}, and {@link
   * TbSqsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSqsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSqsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration.setRegion("us-east-2");

    TbSqsNodeConfiguration tbSqsNodeConfiguration2 = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration2.setRegion("us-east-2");

    // Act and Assert
    assertEquals(tbSqsNodeConfiguration, tbSqsNodeConfiguration2);
    int expectedHashCodeResult = tbSqsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSqsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}, and {@link
   * TbSqsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSqsNodeConfiguration#equals(Object)}
   *   <li>{@link TbSqsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();

    // Act and Assert
    assertEquals(tbSqsNodeConfiguration, tbSqsNodeConfiguration);
    int expectedHashCodeResult = tbSqsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSqsNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSqsNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration.setQueueType(QueueType.STANDARD);

    // Act and Assert
    assertNotEquals(tbSqsNodeConfiguration, new TbSqsNodeConfiguration());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration.setQueueUrlPattern("https://example.org/example");

    // Act and Assert
    assertNotEquals(tbSqsNodeConfiguration, new TbSqsNodeConfiguration());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration.setDelaySeconds(1);

    // Act and Assert
    assertNotEquals(tbSqsNodeConfiguration, new TbSqsNodeConfiguration());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration.setMessageAttributes(new HashMap<>());

    // Act and Assert
    assertNotEquals(tbSqsNodeConfiguration, new TbSqsNodeConfiguration());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(tbSqsNodeConfiguration, new TbSqsNodeConfiguration());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(tbSqsNodeConfiguration, new TbSqsNodeConfiguration());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration.setRegion("us-east-2");

    // Act and Assert
    assertNotEquals(tbSqsNodeConfiguration, new TbSqsNodeConfiguration());
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();

    TbSqsNodeConfiguration tbSqsNodeConfiguration2 = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration2.setQueueType(QueueType.STANDARD);

    // Act and Assert
    assertNotEquals(tbSqsNodeConfiguration, tbSqsNodeConfiguration2);
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();

    TbSqsNodeConfiguration tbSqsNodeConfiguration2 = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration2.setQueueUrlPattern("https://example.org/example");

    // Act and Assert
    assertNotEquals(tbSqsNodeConfiguration, tbSqsNodeConfiguration2);
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();

    TbSqsNodeConfiguration tbSqsNodeConfiguration2 = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration2.setMessageAttributes(new HashMap<>());

    // Act and Assert
    assertNotEquals(tbSqsNodeConfiguration, tbSqsNodeConfiguration2);
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();

    TbSqsNodeConfiguration tbSqsNodeConfiguration2 = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration2.setAccessKeyId("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(tbSqsNodeConfiguration, tbSqsNodeConfiguration2);
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();

    TbSqsNodeConfiguration tbSqsNodeConfiguration2 = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration2.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertNotEquals(tbSqsNodeConfiguration, tbSqsNodeConfiguration2);
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    TbSqsNodeConfiguration tbSqsNodeConfiguration = new TbSqsNodeConfiguration();

    TbSqsNodeConfiguration tbSqsNodeConfiguration2 = new TbSqsNodeConfiguration();
    tbSqsNodeConfiguration2.setRegion("us-east-2");

    // Act and Assert
    assertNotEquals(tbSqsNodeConfiguration, tbSqsNodeConfiguration2);
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSqsNodeConfiguration(), null);
  }

  /**
   * Test {@link TbSqsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSqsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSqsNodeConfiguration.equals(Object)",
    "int TbSqsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSqsNodeConfiguration(), "Different type to TbSqsNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbSqsNodeConfiguration}
   *   <li>{@link TbSqsNodeConfiguration#setAccessKeyId(String)}
   *   <li>{@link TbSqsNodeConfiguration#setDelaySeconds(int)}
   *   <li>{@link TbSqsNodeConfiguration#setMessageAttributes(Map)}
   *   <li>{@link TbSqsNodeConfiguration#setQueueType(QueueType)}
   *   <li>{@link TbSqsNodeConfiguration#setQueueUrlPattern(String)}
   *   <li>{@link TbSqsNodeConfiguration#setRegion(String)}
   *   <li>{@link TbSqsNodeConfiguration#setSecretAccessKey(String)}
   *   <li>{@link TbSqsNodeConfiguration#toString()}
   *   <li>{@link TbSqsNodeConfiguration#getAccessKeyId()}
   *   <li>{@link TbSqsNodeConfiguration#getDelaySeconds()}
   *   <li>{@link TbSqsNodeConfiguration#getMessageAttributes()}
   *   <li>{@link TbSqsNodeConfiguration#getQueueType()}
   *   <li>{@link TbSqsNodeConfiguration#getQueueUrlPattern()}
   *   <li>{@link TbSqsNodeConfiguration#getRegion()}
   *   <li>{@link TbSqsNodeConfiguration#getSecretAccessKey()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbSqsNodeConfiguration.<init>()",
    "String TbSqsNodeConfiguration.getAccessKeyId()",
    "int TbSqsNodeConfiguration.getDelaySeconds()",
    "Map TbSqsNodeConfiguration.getMessageAttributes()",
    "QueueType TbSqsNodeConfiguration.getQueueType()",
    "String TbSqsNodeConfiguration.getQueueUrlPattern()",
    "String TbSqsNodeConfiguration.getRegion()",
    "String TbSqsNodeConfiguration.getSecretAccessKey()",
    "void TbSqsNodeConfiguration.setAccessKeyId(String)",
    "void TbSqsNodeConfiguration.setDelaySeconds(int)",
    "void TbSqsNodeConfiguration.setMessageAttributes(Map)",
    "void TbSqsNodeConfiguration.setQueueType(QueueType)",
    "void TbSqsNodeConfiguration.setQueueUrlPattern(String)",
    "void TbSqsNodeConfiguration.setRegion(String)",
    "void TbSqsNodeConfiguration.setSecretAccessKey(String)",
    "String TbSqsNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbSqsNodeConfiguration actualTbSqsNodeConfiguration = new TbSqsNodeConfiguration();
    actualTbSqsNodeConfiguration.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    actualTbSqsNodeConfiguration.setDelaySeconds(1);
    HashMap<String, String> messageAttributes = new HashMap<>();
    actualTbSqsNodeConfiguration.setMessageAttributes(messageAttributes);
    actualTbSqsNodeConfiguration.setQueueType(QueueType.STANDARD);
    actualTbSqsNodeConfiguration.setQueueUrlPattern("https://example.org/example");
    actualTbSqsNodeConfiguration.setRegion("us-east-2");
    actualTbSqsNodeConfiguration.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");
    String actualToStringResult = actualTbSqsNodeConfiguration.toString();
    String actualAccessKeyId = actualTbSqsNodeConfiguration.getAccessKeyId();
    int actualDelaySeconds = actualTbSqsNodeConfiguration.getDelaySeconds();
    Map<String, String> actualMessageAttributes =
        actualTbSqsNodeConfiguration.getMessageAttributes();
    QueueType actualQueueType = actualTbSqsNodeConfiguration.getQueueType();
    String actualQueueUrlPattern = actualTbSqsNodeConfiguration.getQueueUrlPattern();
    String actualRegion = actualTbSqsNodeConfiguration.getRegion();

    // Assert
    assertEquals("EXAMPLEakiAIOSFODNN7", actualAccessKeyId);
    assertEquals("EXAMPLEakiAIOSFODNN7", actualTbSqsNodeConfiguration.getSecretAccessKey());
    assertEquals(
        "TbSqsNodeConfiguration(queueType=STANDARD, queueUrlPattern=https://example.org/example, delaySeconds=1,"
            + " messageAttributes={}, accessKeyId=EXAMPLEakiAIOSFODNN7, secretAccessKey=EXAMPLEakiAIOSFODNN7,"
            + " region=us-east-2)",
        actualToStringResult);
    assertEquals("https://example.org/example", actualQueueUrlPattern);
    assertEquals("us-east-2", actualRegion);
    assertEquals(1, actualDelaySeconds);
    assertEquals(QueueType.STANDARD, actualQueueType);
    assertTrue(actualMessageAttributes.isEmpty());
    assertSame(messageAttributes, actualMessageAttributes);
  }
}
