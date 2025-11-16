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
package org.thingsboard.rule.engine.metadata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CalculateDeltaNodeConfigurationDiffblueTest {
  /**
   * Test {@link CalculateDeltaNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "CalculateDeltaNodeConfiguration CalculateDeltaNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    CalculateDeltaNodeConfiguration actualDefaultConfigurationResult =
        new CalculateDeltaNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals("delta", actualDefaultConfigurationResult.getOutputValueKey());
    assertEquals("periodInMs", actualDefaultConfigurationResult.getPeriodValueKey());
    assertEquals("pulseCounter", actualDefaultConfigurationResult.getInputValueKey());
    assertNull(actualDefaultConfigurationResult.getRound());
    assertFalse(actualDefaultConfigurationResult.isAddPeriodBetweenMsgs());
    assertFalse(actualDefaultConfigurationResult.isExcludeZeroDeltas());
    assertTrue(actualDefaultConfigurationResult.isTellFailureIfDeltaIsNegative());
    assertTrue(actualDefaultConfigurationResult.isUseCache());
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}, and {@link
   * CalculateDeltaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CalculateDeltaNodeConfiguration#equals(Object)}
   *   <li>{@link CalculateDeltaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration2 =
        new CalculateDeltaNodeConfiguration();

    // Act and Assert
    assertEquals(calculateDeltaNodeConfiguration, calculateDeltaNodeConfiguration2);
    assertEquals(
        calculateDeltaNodeConfiguration.hashCode(), calculateDeltaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}, and {@link
   * CalculateDeltaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CalculateDeltaNodeConfiguration#equals(Object)}
   *   <li>{@link CalculateDeltaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration.setInputValueKey("42");

    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration2 =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration2.setInputValueKey("42");

    // Act and Assert
    assertEquals(calculateDeltaNodeConfiguration, calculateDeltaNodeConfiguration2);
    assertEquals(
        calculateDeltaNodeConfiguration.hashCode(), calculateDeltaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}, and {@link
   * CalculateDeltaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CalculateDeltaNodeConfiguration#equals(Object)}
   *   <li>{@link CalculateDeltaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration.setOutputValueKey("42");

    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration2 =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration2.setOutputValueKey("42");

    // Act and Assert
    assertEquals(calculateDeltaNodeConfiguration, calculateDeltaNodeConfiguration2);
    assertEquals(
        calculateDeltaNodeConfiguration.hashCode(), calculateDeltaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}, and {@link
   * CalculateDeltaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CalculateDeltaNodeConfiguration#equals(Object)}
   *   <li>{@link CalculateDeltaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration.setPeriodValueKey("42");

    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration2 =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration2.setPeriodValueKey("42");

    // Act and Assert
    assertEquals(calculateDeltaNodeConfiguration, calculateDeltaNodeConfiguration2);
    assertEquals(
        calculateDeltaNodeConfiguration.hashCode(), calculateDeltaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}, and {@link
   * CalculateDeltaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CalculateDeltaNodeConfiguration#equals(Object)}
   *   <li>{@link CalculateDeltaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration.setRound(1);

    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration2 =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration2.setRound(1);

    // Act and Assert
    assertEquals(calculateDeltaNodeConfiguration, calculateDeltaNodeConfiguration2);
    assertEquals(
        calculateDeltaNodeConfiguration.hashCode(), calculateDeltaNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}, and {@link
   * CalculateDeltaNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CalculateDeltaNodeConfiguration#equals(Object)}
   *   <li>{@link CalculateDeltaNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();

    // Act and Assert
    assertEquals(calculateDeltaNodeConfiguration, calculateDeltaNodeConfiguration);
    int expectedHashCodeResult = calculateDeltaNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, calculateDeltaNodeConfiguration.hashCode());
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CalculateDeltaNodeConfiguration(), 1);
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration.setInputValueKey("42");

    // Act and Assert
    assertNotEquals(calculateDeltaNodeConfiguration, new CalculateDeltaNodeConfiguration());
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration.setOutputValueKey("42");

    // Act and Assert
    assertNotEquals(calculateDeltaNodeConfiguration, new CalculateDeltaNodeConfiguration());
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration.setUseCache(true);

    // Act and Assert
    assertNotEquals(calculateDeltaNodeConfiguration, new CalculateDeltaNodeConfiguration());
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration.setAddPeriodBetweenMsgs(true);

    // Act and Assert
    assertNotEquals(calculateDeltaNodeConfiguration, new CalculateDeltaNodeConfiguration());
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration.setPeriodValueKey("42");

    // Act and Assert
    assertNotEquals(calculateDeltaNodeConfiguration, new CalculateDeltaNodeConfiguration());
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration.setRound(1);

    // Act and Assert
    assertNotEquals(calculateDeltaNodeConfiguration, new CalculateDeltaNodeConfiguration());
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration.setTellFailureIfDeltaIsNegative(true);

    // Act and Assert
    assertNotEquals(calculateDeltaNodeConfiguration, new CalculateDeltaNodeConfiguration());
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration.setExcludeZeroDeltas(true);

    // Act and Assert
    assertNotEquals(calculateDeltaNodeConfiguration, new CalculateDeltaNodeConfiguration());
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();

    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration2 =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration2.setInputValueKey("42");

    // Act and Assert
    assertNotEquals(calculateDeltaNodeConfiguration, calculateDeltaNodeConfiguration2);
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();

    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration2 =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration2.setOutputValueKey("42");

    // Act and Assert
    assertNotEquals(calculateDeltaNodeConfiguration, calculateDeltaNodeConfiguration2);
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();

    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration2 =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration2.setPeriodValueKey("42");

    // Act and Assert
    assertNotEquals(calculateDeltaNodeConfiguration, calculateDeltaNodeConfiguration2);
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();

    CalculateDeltaNodeConfiguration calculateDeltaNodeConfiguration2 =
        new CalculateDeltaNodeConfiguration();
    calculateDeltaNodeConfiguration2.setRound(1);

    // Act and Assert
    assertNotEquals(calculateDeltaNodeConfiguration, calculateDeltaNodeConfiguration2);
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CalculateDeltaNodeConfiguration(), null);
  }

  /**
   * Test {@link CalculateDeltaNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CalculateDeltaNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean CalculateDeltaNodeConfiguration.equals(Object)",
    "int CalculateDeltaNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new CalculateDeltaNodeConfiguration(), "Different type to CalculateDeltaNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link CalculateDeltaNodeConfiguration}
   *   <li>{@link CalculateDeltaNodeConfiguration#setAddPeriodBetweenMsgs(boolean)}
   *   <li>{@link CalculateDeltaNodeConfiguration#setExcludeZeroDeltas(boolean)}
   *   <li>{@link CalculateDeltaNodeConfiguration#setInputValueKey(String)}
   *   <li>{@link CalculateDeltaNodeConfiguration#setOutputValueKey(String)}
   *   <li>{@link CalculateDeltaNodeConfiguration#setPeriodValueKey(String)}
   *   <li>{@link CalculateDeltaNodeConfiguration#setRound(Integer)}
   *   <li>{@link CalculateDeltaNodeConfiguration#setTellFailureIfDeltaIsNegative(boolean)}
   *   <li>{@link CalculateDeltaNodeConfiguration#setUseCache(boolean)}
   *   <li>{@link CalculateDeltaNodeConfiguration#toString()}
   *   <li>{@link CalculateDeltaNodeConfiguration#getInputValueKey()}
   *   <li>{@link CalculateDeltaNodeConfiguration#getOutputValueKey()}
   *   <li>{@link CalculateDeltaNodeConfiguration#getPeriodValueKey()}
   *   <li>{@link CalculateDeltaNodeConfiguration#getRound()}
   *   <li>{@link CalculateDeltaNodeConfiguration#isAddPeriodBetweenMsgs()}
   *   <li>{@link CalculateDeltaNodeConfiguration#isExcludeZeroDeltas()}
   *   <li>{@link CalculateDeltaNodeConfiguration#isTellFailureIfDeltaIsNegative()}
   *   <li>{@link CalculateDeltaNodeConfiguration#isUseCache()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void CalculateDeltaNodeConfiguration.<init>()",
    "String CalculateDeltaNodeConfiguration.getInputValueKey()",
    "String CalculateDeltaNodeConfiguration.getOutputValueKey()",
    "String CalculateDeltaNodeConfiguration.getPeriodValueKey()",
    "Integer CalculateDeltaNodeConfiguration.getRound()",
    "boolean CalculateDeltaNodeConfiguration.isAddPeriodBetweenMsgs()",
    "boolean CalculateDeltaNodeConfiguration.isExcludeZeroDeltas()",
    "boolean CalculateDeltaNodeConfiguration.isTellFailureIfDeltaIsNegative()",
    "boolean CalculateDeltaNodeConfiguration.isUseCache()",
    "void CalculateDeltaNodeConfiguration.setAddPeriodBetweenMsgs(boolean)",
    "void CalculateDeltaNodeConfiguration.setExcludeZeroDeltas(boolean)",
    "void CalculateDeltaNodeConfiguration.setInputValueKey(String)",
    "void CalculateDeltaNodeConfiguration.setOutputValueKey(String)",
    "void CalculateDeltaNodeConfiguration.setPeriodValueKey(String)",
    "void CalculateDeltaNodeConfiguration.setRound(Integer)",
    "void CalculateDeltaNodeConfiguration.setTellFailureIfDeltaIsNegative(boolean)",
    "void CalculateDeltaNodeConfiguration.setUseCache(boolean)",
    "String CalculateDeltaNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    CalculateDeltaNodeConfiguration actualCalculateDeltaNodeConfiguration =
        new CalculateDeltaNodeConfiguration();
    actualCalculateDeltaNodeConfiguration.setAddPeriodBetweenMsgs(true);
    actualCalculateDeltaNodeConfiguration.setExcludeZeroDeltas(true);
    actualCalculateDeltaNodeConfiguration.setInputValueKey("42");
    actualCalculateDeltaNodeConfiguration.setOutputValueKey("42");
    actualCalculateDeltaNodeConfiguration.setPeriodValueKey("42");
    actualCalculateDeltaNodeConfiguration.setRound(1);
    actualCalculateDeltaNodeConfiguration.setTellFailureIfDeltaIsNegative(true);
    actualCalculateDeltaNodeConfiguration.setUseCache(true);
    String actualToStringResult = actualCalculateDeltaNodeConfiguration.toString();
    String actualInputValueKey = actualCalculateDeltaNodeConfiguration.getInputValueKey();
    String actualOutputValueKey = actualCalculateDeltaNodeConfiguration.getOutputValueKey();
    String actualPeriodValueKey = actualCalculateDeltaNodeConfiguration.getPeriodValueKey();
    Integer actualRound = actualCalculateDeltaNodeConfiguration.getRound();
    boolean actualIsAddPeriodBetweenMsgsResult =
        actualCalculateDeltaNodeConfiguration.isAddPeriodBetweenMsgs();
    boolean actualIsExcludeZeroDeltasResult =
        actualCalculateDeltaNodeConfiguration.isExcludeZeroDeltas();
    boolean actualIsTellFailureIfDeltaIsNegativeResult =
        actualCalculateDeltaNodeConfiguration.isTellFailureIfDeltaIsNegative();
    boolean actualIsUseCacheResult = actualCalculateDeltaNodeConfiguration.isUseCache();

    // Assert
    assertEquals("42", actualInputValueKey);
    assertEquals("42", actualOutputValueKey);
    assertEquals("42", actualPeriodValueKey);
    assertEquals(
        "CalculateDeltaNodeConfiguration(inputValueKey=42, outputValueKey=42, useCache=true, addPeriodBetweenMsgs"
            + "=true, periodValueKey=42, round=1, tellFailureIfDeltaIsNegative=true, excludeZeroDeltas=true)",
        actualToStringResult);
    assertEquals(1, actualRound.intValue());
    assertTrue(actualIsAddPeriodBetweenMsgsResult);
    assertTrue(actualIsExcludeZeroDeltasResult);
    assertTrue(actualIsTellFailureIfDeltaIsNegativeResult);
    assertTrue(actualIsUseCacheResult);
  }
}
