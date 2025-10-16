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
package org.thingsboard.rule.engine.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbMsgTimeseriesNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbMsgTimeseriesNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbMsgTimeseriesNodeConfiguration TbMsgTimeseriesNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange
    TbMsgTimeseriesNodeConfiguration tbMsgTimeseriesNodeConfiguration =
        new TbMsgTimeseriesNodeConfiguration();

    // Act
    TbMsgTimeseriesNodeConfiguration actualDefaultConfigurationResult =
        tbMsgTimeseriesNodeConfiguration.defaultConfiguration();

    // Assert
    assertEquals(tbMsgTimeseriesNodeConfiguration, actualDefaultConfigurationResult);
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}, and {@link
   * TbMsgTimeseriesNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTimeseriesNodeConfiguration.equals(Object)",
    "int TbMsgTimeseriesNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbMsgTimeseriesNodeConfiguration tbMsgTimeseriesNodeConfiguration =
        new TbMsgTimeseriesNodeConfiguration();
    TbMsgTimeseriesNodeConfiguration tbMsgTimeseriesNodeConfiguration2 =
        new TbMsgTimeseriesNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgTimeseriesNodeConfiguration, tbMsgTimeseriesNodeConfiguration2);
    assertEquals(
        tbMsgTimeseriesNodeConfiguration.hashCode(), tbMsgTimeseriesNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}, and {@link
   * TbMsgTimeseriesNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTimeseriesNodeConfiguration.equals(Object)",
    "int TbMsgTimeseriesNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbMsgTimeseriesNodeConfiguration tbMsgTimeseriesNodeConfiguration =
        new TbMsgTimeseriesNodeConfiguration();

    // Act and Assert
    assertEquals(tbMsgTimeseriesNodeConfiguration, tbMsgTimeseriesNodeConfiguration);
    int expectedHashCodeResult = tbMsgTimeseriesNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbMsgTimeseriesNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTimeseriesNodeConfiguration.equals(Object)",
    "int TbMsgTimeseriesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgTimeseriesNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTimeseriesNodeConfiguration.equals(Object)",
    "int TbMsgTimeseriesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbMsgTimeseriesNodeConfiguration tbMsgTimeseriesNodeConfiguration =
        new TbMsgTimeseriesNodeConfiguration();
    tbMsgTimeseriesNodeConfiguration.setDefaultTTL(1L);

    // Act and Assert
    assertNotEquals(tbMsgTimeseriesNodeConfiguration, new TbMsgTimeseriesNodeConfiguration());
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTimeseriesNodeConfiguration.equals(Object)",
    "int TbMsgTimeseriesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbMsgTimeseriesNodeConfiguration tbMsgTimeseriesNodeConfiguration =
        new TbMsgTimeseriesNodeConfiguration();
    tbMsgTimeseriesNodeConfiguration.setSkipLatestPersistence(true);

    // Act and Assert
    assertNotEquals(tbMsgTimeseriesNodeConfiguration, new TbMsgTimeseriesNodeConfiguration());
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTimeseriesNodeConfiguration.equals(Object)",
    "int TbMsgTimeseriesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbMsgTimeseriesNodeConfiguration tbMsgTimeseriesNodeConfiguration =
        new TbMsgTimeseriesNodeConfiguration();
    tbMsgTimeseriesNodeConfiguration.setUseServerTs(true);

    // Act and Assert
    assertNotEquals(tbMsgTimeseriesNodeConfiguration, new TbMsgTimeseriesNodeConfiguration());
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTimeseriesNodeConfiguration.equals(Object)",
    "int TbMsgTimeseriesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbMsgTimeseriesNodeConfiguration(), null);
  }

  /**
   * Test {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbMsgTimeseriesNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbMsgTimeseriesNodeConfiguration.equals(Object)",
    "int TbMsgTimeseriesNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbMsgTimeseriesNodeConfiguration(),
        "Different type to TbMsgTimeseriesNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbMsgTimeseriesNodeConfiguration}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#setDefaultTTL(long)}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#setSkipLatestPersistence(boolean)}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#setUseServerTs(boolean)}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#toString()}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#getDefaultTTL()}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#isSkipLatestPersistence()}
   *   <li>{@link TbMsgTimeseriesNodeConfiguration#isUseServerTs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbMsgTimeseriesNodeConfiguration.<init>()",
    "long TbMsgTimeseriesNodeConfiguration.getDefaultTTL()",
    "boolean TbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence()",
    "boolean TbMsgTimeseriesNodeConfiguration.isUseServerTs()",
    "void TbMsgTimeseriesNodeConfiguration.setDefaultTTL(long)",
    "void TbMsgTimeseriesNodeConfiguration.setSkipLatestPersistence(boolean)",
    "void TbMsgTimeseriesNodeConfiguration.setUseServerTs(boolean)",
    "String TbMsgTimeseriesNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbMsgTimeseriesNodeConfiguration actualTbMsgTimeseriesNodeConfiguration =
        new TbMsgTimeseriesNodeConfiguration();
    actualTbMsgTimeseriesNodeConfiguration.setDefaultTTL(1L);
    actualTbMsgTimeseriesNodeConfiguration.setSkipLatestPersistence(true);
    actualTbMsgTimeseriesNodeConfiguration.setUseServerTs(true);
    String actualToStringResult = actualTbMsgTimeseriesNodeConfiguration.toString();
    long actualDefaultTTL = actualTbMsgTimeseriesNodeConfiguration.getDefaultTTL();
    boolean actualIsSkipLatestPersistenceResult =
        actualTbMsgTimeseriesNodeConfiguration.isSkipLatestPersistence();

    // Assert
    assertEquals(
        "TbMsgTimeseriesNodeConfiguration(defaultTTL=1, skipLatestPersistence=true, useServerTs=true)",
        actualToStringResult);
    assertEquals(1L, actualDefaultTTL);
    assertTrue(actualIsSkipLatestPersistenceResult);
    assertTrue(actualTbMsgTimeseriesNodeConfiguration.isUseServerTs());
  }
}
