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
package org.thingsboard.rule.engine.deduplication;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbMsgDeduplicationNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbMsgDeduplicationNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbMsgDeduplicationNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsgDeduplicationNodeConfiguration TbMsgDeduplicationNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbMsgDeduplicationNodeConfiguration actualDefaultConfigurationResult =
        new TbMsgDeduplicationNodeConfiguration().defaultConfiguration();

    // Assert
    assertNull(actualDefaultConfigurationResult.getOutMsgType());
    assertEquals(100, actualDefaultConfigurationResult.getMaxPendingMsgs());
    assertEquals(3, actualDefaultConfigurationResult.getMaxRetries());
    assertEquals(60, actualDefaultConfigurationResult.getInterval());
    assertEquals(DeduplicationStrategy.FIRST, actualDefaultConfigurationResult.getStrategy());
  }

  /**
   * Test {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}, and {@link
   * TbMsgDeduplicationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgDeduplicationNodeConfiguration.equals(Object)",
    "int TbMsgDeduplicationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration =
        new TbMsgDeduplicationNodeConfiguration();
    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration2 =
        new TbMsgDeduplicationNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgDeduplicationNodeConfiguration, tbMsgDeduplicationNodeConfiguration2);
    assertEquals(
        tbMsgDeduplicationNodeConfiguration.hashCode(),
        tbMsgDeduplicationNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}, and {@link
   * TbMsgDeduplicationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgDeduplicationNodeConfiguration.equals(Object)",
    "int TbMsgDeduplicationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration =
        new TbMsgDeduplicationNodeConfiguration();
    tbMsgDeduplicationNodeConfiguration.setStrategy(DeduplicationStrategy.FIRST);

    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration2 =
        new TbMsgDeduplicationNodeConfiguration();
    tbMsgDeduplicationNodeConfiguration2.setStrategy(DeduplicationStrategy.FIRST);

    // Act and Assert
    assertEquals(tbMsgDeduplicationNodeConfiguration, tbMsgDeduplicationNodeConfiguration2);
    assertEquals(
        tbMsgDeduplicationNodeConfiguration.hashCode(),
        tbMsgDeduplicationNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}, and {@link
   * TbMsgDeduplicationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgDeduplicationNodeConfiguration.equals(Object)",
    "int TbMsgDeduplicationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration =
        new TbMsgDeduplicationNodeConfiguration();
    tbMsgDeduplicationNodeConfiguration.setOutMsgType("Out Msg Type");

    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration2 =
        new TbMsgDeduplicationNodeConfiguration();
    tbMsgDeduplicationNodeConfiguration2.setOutMsgType("Out Msg Type");

    // Act and Assert
    assertEquals(tbMsgDeduplicationNodeConfiguration, tbMsgDeduplicationNodeConfiguration2);
    assertEquals(
        tbMsgDeduplicationNodeConfiguration.hashCode(),
        tbMsgDeduplicationNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}, and {@link
   * TbMsgDeduplicationNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgDeduplicationNodeConfiguration.equals(Object)",
    "int TbMsgDeduplicationNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration =
        new TbMsgDeduplicationNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgDeduplicationNodeConfiguration, tbMsgDeduplicationNodeConfiguration);
    int expectedHashCodeResult = tbMsgDeduplicationNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgDeduplicationNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgDeduplicationNodeConfiguration.equals(Object)",
    "int TbMsgDeduplicationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgDeduplicationNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgDeduplicationNodeConfiguration.equals(Object)",
    "int TbMsgDeduplicationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration =
        new TbMsgDeduplicationNodeConfiguration();
    tbMsgDeduplicationNodeConfiguration.setInterval(42);

    // Act and Assert
    assertNotEquals(tbMsgDeduplicationNodeConfiguration, new TbMsgDeduplicationNodeConfiguration());
  }

  /**
   * Test {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgDeduplicationNodeConfiguration.equals(Object)",
    "int TbMsgDeduplicationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration =
        new TbMsgDeduplicationNodeConfiguration();
    tbMsgDeduplicationNodeConfiguration.setStrategy(DeduplicationStrategy.FIRST);

    // Act and Assert
    assertNotEquals(tbMsgDeduplicationNodeConfiguration, new TbMsgDeduplicationNodeConfiguration());
  }

  /**
   * Test {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgDeduplicationNodeConfiguration.equals(Object)",
    "int TbMsgDeduplicationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration =
        new TbMsgDeduplicationNodeConfiguration();
    tbMsgDeduplicationNodeConfiguration.setOutMsgType("Out Msg Type");

    // Act and Assert
    assertNotEquals(tbMsgDeduplicationNodeConfiguration, new TbMsgDeduplicationNodeConfiguration());
  }

  /**
   * Test {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgDeduplicationNodeConfiguration.equals(Object)",
    "int TbMsgDeduplicationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration =
        new TbMsgDeduplicationNodeConfiguration();
    tbMsgDeduplicationNodeConfiguration.setMaxPendingMsgs(3);

    // Act and Assert
    assertNotEquals(tbMsgDeduplicationNodeConfiguration, new TbMsgDeduplicationNodeConfiguration());
  }

  /**
   * Test {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgDeduplicationNodeConfiguration.equals(Object)",
    "int TbMsgDeduplicationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration =
        new TbMsgDeduplicationNodeConfiguration();
    tbMsgDeduplicationNodeConfiguration.setMaxRetries(3);

    // Act and Assert
    assertNotEquals(tbMsgDeduplicationNodeConfiguration, new TbMsgDeduplicationNodeConfiguration());
  }

  /**
   * Test {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgDeduplicationNodeConfiguration.equals(Object)",
    "int TbMsgDeduplicationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration =
        new TbMsgDeduplicationNodeConfiguration();

    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration2 =
        new TbMsgDeduplicationNodeConfiguration();
    tbMsgDeduplicationNodeConfiguration2.setStrategy(DeduplicationStrategy.FIRST);

    // Act and Assert
    assertNotEquals(tbMsgDeduplicationNodeConfiguration, tbMsgDeduplicationNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgDeduplicationNodeConfiguration.equals(Object)",
    "int TbMsgDeduplicationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration =
        new TbMsgDeduplicationNodeConfiguration();

    TbMsgDeduplicationNodeConfiguration tbMsgDeduplicationNodeConfiguration2 =
        new TbMsgDeduplicationNodeConfiguration();
    tbMsgDeduplicationNodeConfiguration2.setOutMsgType("Out Msg Type");

    // Act and Assert
    assertNotEquals(tbMsgDeduplicationNodeConfiguration, tbMsgDeduplicationNodeConfiguration2);
  }

  /**
   * Test {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgDeduplicationNodeConfiguration.equals(Object)",
    "int TbMsgDeduplicationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgDeduplicationNodeConfiguration(), null);
  }

  /**
   * Test {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgDeduplicationNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgDeduplicationNodeConfiguration.equals(Object)",
    "int TbMsgDeduplicationNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbMsgDeduplicationNodeConfiguration(),
        "Different type to TbMsgDeduplicationNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMsgDeduplicationNodeConfiguration}
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#setInterval(int)}
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#setMaxPendingMsgs(int)}
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#setMaxRetries(int)}
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#setOutMsgType(String)}
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#setStrategy(DeduplicationStrategy)}
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#toString()}
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#getInterval()}
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#getMaxPendingMsgs()}
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#getMaxRetries()}
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#getOutMsgType()}
   *   <li>{@link TbMsgDeduplicationNodeConfiguration#getStrategy()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbMsgDeduplicationNodeConfiguration.<init>()",
    "int TbMsgDeduplicationNodeConfiguration.getInterval()",
    "int TbMsgDeduplicationNodeConfiguration.getMaxPendingMsgs()",
    "int TbMsgDeduplicationNodeConfiguration.getMaxRetries()",
    "String TbMsgDeduplicationNodeConfiguration.getOutMsgType()",
    "DeduplicationStrategy TbMsgDeduplicationNodeConfiguration.getStrategy()",
    "void TbMsgDeduplicationNodeConfiguration.setInterval(int)",
    "void TbMsgDeduplicationNodeConfiguration.setMaxPendingMsgs(int)",
    "void TbMsgDeduplicationNodeConfiguration.setMaxRetries(int)",
    "void TbMsgDeduplicationNodeConfiguration.setOutMsgType(String)",
    "void TbMsgDeduplicationNodeConfiguration.setStrategy(DeduplicationStrategy)",
    "String TbMsgDeduplicationNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgDeduplicationNodeConfiguration actualTbMsgDeduplicationNodeConfiguration =
        new TbMsgDeduplicationNodeConfiguration();
    actualTbMsgDeduplicationNodeConfiguration.setInterval(42);
    actualTbMsgDeduplicationNodeConfiguration.setMaxPendingMsgs(3);
    actualTbMsgDeduplicationNodeConfiguration.setMaxRetries(3);
    actualTbMsgDeduplicationNodeConfiguration.setOutMsgType("Out Msg Type");
    actualTbMsgDeduplicationNodeConfiguration.setStrategy(DeduplicationStrategy.FIRST);
    String actualToStringResult = actualTbMsgDeduplicationNodeConfiguration.toString();
    int actualInterval = actualTbMsgDeduplicationNodeConfiguration.getInterval();
    int actualMaxPendingMsgs = actualTbMsgDeduplicationNodeConfiguration.getMaxPendingMsgs();
    int actualMaxRetries = actualTbMsgDeduplicationNodeConfiguration.getMaxRetries();
    String actualOutMsgType = actualTbMsgDeduplicationNodeConfiguration.getOutMsgType();

    // Assert
    assertEquals("Out Msg Type", actualOutMsgType);
    assertEquals(
        "TbMsgDeduplicationNodeConfiguration(interval=42, strategy=FIRST, outMsgType=Out Msg Type, maxPendingMsgs=3,"
            + " maxRetries=3)",
        actualToStringResult);
    assertEquals(3, actualMaxPendingMsgs);
    assertEquals(3, actualMaxRetries);
    assertEquals(42, actualInterval);
    assertEquals(
        DeduplicationStrategy.FIRST, actualTbMsgDeduplicationNodeConfiguration.getStrategy());
  }
}
