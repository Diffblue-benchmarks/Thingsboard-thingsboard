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
package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbUnassignFromCustomerNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbUnassignFromCustomerNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbUnassignFromCustomerNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbUnassignFromCustomerNodeConfiguration TbUnassignFromCustomerNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange, Act and Assert
    assertEquals(
        "",
        new TbUnassignFromCustomerNodeConfiguration()
            .defaultConfiguration()
            .getCustomerNamePattern());
  }

  /**
   * Test {@link TbUnassignFromCustomerNodeConfiguration#equals(Object)}, and {@link
   * TbUnassignFromCustomerNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUnassignFromCustomerNodeConfiguration#equals(Object)}
   *   <li>{@link TbUnassignFromCustomerNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbUnassignFromCustomerNodeConfiguration.equals(Object)",
    "int TbUnassignFromCustomerNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbUnassignFromCustomerNodeConfiguration tbUnassignFromCustomerNodeConfiguration =
        new TbUnassignFromCustomerNodeConfiguration();
    TbUnassignFromCustomerNodeConfiguration tbUnassignFromCustomerNodeConfiguration2 =
        new TbUnassignFromCustomerNodeConfiguration();

    // Act and Assert
    assertEquals(tbUnassignFromCustomerNodeConfiguration, tbUnassignFromCustomerNodeConfiguration2);
    assertEquals(
        tbUnassignFromCustomerNodeConfiguration.hashCode(),
        tbUnassignFromCustomerNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbUnassignFromCustomerNodeConfiguration#equals(Object)}, and {@link
   * TbUnassignFromCustomerNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUnassignFromCustomerNodeConfiguration#equals(Object)}
   *   <li>{@link TbUnassignFromCustomerNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbUnassignFromCustomerNodeConfiguration.equals(Object)",
    "int TbUnassignFromCustomerNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbUnassignFromCustomerNodeConfiguration tbUnassignFromCustomerNodeConfiguration =
        new TbUnassignFromCustomerNodeConfiguration();

    // Act and Assert
    assertEquals(tbUnassignFromCustomerNodeConfiguration, tbUnassignFromCustomerNodeConfiguration);
    int expectedHashCodeResult = tbUnassignFromCustomerNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbUnassignFromCustomerNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbUnassignFromCustomerNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbUnassignFromCustomerNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbUnassignFromCustomerNodeConfiguration.equals(Object)",
    "int TbUnassignFromCustomerNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbUnassignFromCustomerNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbUnassignFromCustomerNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbUnassignFromCustomerNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbUnassignFromCustomerNodeConfiguration.equals(Object)",
    "int TbUnassignFromCustomerNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbUnassignFromCustomerNodeConfiguration tbUnassignFromCustomerNodeConfiguration =
        new TbUnassignFromCustomerNodeConfiguration();
    tbUnassignFromCustomerNodeConfiguration.setCustomerNamePattern("Customer Name Pattern");

    // Act and Assert
    assertNotEquals(
        tbUnassignFromCustomerNodeConfiguration, new TbUnassignFromCustomerNodeConfiguration());
  }

  /**
   * Test {@link TbUnassignFromCustomerNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbUnassignFromCustomerNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbUnassignFromCustomerNodeConfiguration.equals(Object)",
    "int TbUnassignFromCustomerNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbUnassignFromCustomerNodeConfiguration(), null);
  }

  /**
   * Test {@link TbUnassignFromCustomerNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbUnassignFromCustomerNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbUnassignFromCustomerNodeConfiguration.equals(Object)",
    "int TbUnassignFromCustomerNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbUnassignFromCustomerNodeConfiguration(),
        "Different type to TbUnassignFromCustomerNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbUnassignFromCustomerNodeConfiguration}
   *   <li>{@link TbUnassignFromCustomerNodeConfiguration#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbUnassignFromCustomerNodeConfiguration.<init>()",
    "java.lang.String TbUnassignFromCustomerNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbUnassignFromCustomerNodeConfiguration actualTbUnassignFromCustomerNodeConfiguration =
        new TbUnassignFromCustomerNodeConfiguration();

    // Assert
    assertEquals(
        "TbUnassignFromCustomerNodeConfiguration()",
        actualTbUnassignFromCustomerNodeConfiguration.toString());
    assertNull(actualTbUnassignFromCustomerNodeConfiguration.getCustomerNamePattern());
  }
}
