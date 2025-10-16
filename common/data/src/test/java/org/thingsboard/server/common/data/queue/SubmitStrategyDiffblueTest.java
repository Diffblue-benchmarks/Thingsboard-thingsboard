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
package org.thingsboard.server.common.data.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SubmitStrategyDiffblueTest {
  /**
   * Test {@link SubmitStrategy#equals(Object)}, and {@link SubmitStrategy#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SubmitStrategy#equals(Object)}
   *   <li>{@link SubmitStrategy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SubmitStrategy.equals(Object)", "int SubmitStrategy.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    // Act and Assert
    assertEquals(submitStrategy, submitStrategy2);
    assertEquals(submitStrategy.hashCode(), submitStrategy2.hashCode());
  }

  /**
   * Test {@link SubmitStrategy#equals(Object)}, and {@link SubmitStrategy#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SubmitStrategy#equals(Object)}
   *   <li>{@link SubmitStrategy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SubmitStrategy.equals(Object)", "int SubmitStrategy.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(null);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(null);

    // Act and Assert
    assertEquals(submitStrategy, submitStrategy2);
    assertEquals(submitStrategy.hashCode(), submitStrategy2.hashCode());
  }

  /**
   * Test {@link SubmitStrategy#equals(Object)}, and {@link SubmitStrategy#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SubmitStrategy#equals(Object)}
   *   <li>{@link SubmitStrategy#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SubmitStrategy.equals(Object)", "int SubmitStrategy.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    // Act and Assert
    assertEquals(submitStrategy, submitStrategy);
    int expectedHashCodeResult = submitStrategy.hashCode();
    assertEquals(expectedHashCodeResult, submitStrategy.hashCode());
  }

  /**
   * Test {@link SubmitStrategy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SubmitStrategy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SubmitStrategy.equals(Object)", "int SubmitStrategy.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(1);
    submitStrategy.setType(SubmitStrategyType.BURST);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    // Act and Assert
    assertNotEquals(submitStrategy, submitStrategy2);
  }

  /**
   * Test {@link SubmitStrategy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SubmitStrategy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SubmitStrategy.equals(Object)", "int SubmitStrategy.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(null);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    // Act and Assert
    assertNotEquals(submitStrategy, submitStrategy2);
  }

  /**
   * Test {@link SubmitStrategy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SubmitStrategy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SubmitStrategy.equals(Object)", "int SubmitStrategy.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BATCH);

    SubmitStrategy submitStrategy2 = new SubmitStrategy();
    submitStrategy2.setBatchSize(3);
    submitStrategy2.setType(SubmitStrategyType.BURST);

    // Act and Assert
    assertNotEquals(submitStrategy, submitStrategy2);
  }

  /**
   * Test {@link SubmitStrategy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SubmitStrategy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SubmitStrategy.equals(Object)", "int SubmitStrategy.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    // Act and Assert
    assertNotEquals(submitStrategy, null);
  }

  /**
   * Test {@link SubmitStrategy#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SubmitStrategy#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SubmitStrategy.equals(Object)", "int SubmitStrategy.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    // Act and Assert
    assertNotEquals(submitStrategy, "Different type to SubmitStrategy");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SubmitStrategy}
   *   <li>{@link SubmitStrategy#setBatchSize(int)}
   *   <li>{@link SubmitStrategy#setType(SubmitStrategyType)}
   *   <li>{@link SubmitStrategy#toString()}
   *   <li>{@link SubmitStrategy#getBatchSize()}
   *   <li>{@link SubmitStrategy#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SubmitStrategy.<init>()",
    "int SubmitStrategy.getBatchSize()",
    "SubmitStrategyType SubmitStrategy.getType()",
    "void SubmitStrategy.setBatchSize(int)",
    "void SubmitStrategy.setType(SubmitStrategyType)",
    "String SubmitStrategy.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SubmitStrategy actualSubmitStrategy = new SubmitStrategy();
    actualSubmitStrategy.setBatchSize(3);
    actualSubmitStrategy.setType(SubmitStrategyType.BURST);
    String actualToStringResult = actualSubmitStrategy.toString();
    int actualBatchSize = actualSubmitStrategy.getBatchSize();

    // Assert
    assertEquals("SubmitStrategy(type=BURST, batchSize=3)", actualToStringResult);
    assertEquals(3, actualBatchSize);
    assertEquals(SubmitStrategyType.BURST, actualSubmitStrategy.getType());
  }
}
