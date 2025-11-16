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
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.util.TbMsgSource;

class TbGetCustomerDetailsNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbGetCustomerDetailsNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbGetCustomerDetailsNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbGetCustomerDetailsNodeConfiguration TbGetCustomerDetailsNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbGetCustomerDetailsNodeConfiguration actualDefaultConfigurationResult =
        new TbGetCustomerDetailsNodeConfiguration().defaultConfiguration();

    // Assert
    assertEquals(TbMsgSource.DATA, actualDefaultConfigurationResult.getFetchTo());
    assertTrue(actualDefaultConfigurationResult.getDetailsList().isEmpty());
  }

  /**
   * Test {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}, and {@link
   * TbGetCustomerDetailsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetCustomerDetailsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetCustomerDetailsNodeConfiguration.equals(Object)",
    "int TbGetCustomerDetailsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration =
        new TbGetCustomerDetailsNodeConfiguration();
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration2 =
        new TbGetCustomerDetailsNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetCustomerDetailsNodeConfiguration, tbGetCustomerDetailsNodeConfiguration2);
    assertEquals(
        tbGetCustomerDetailsNodeConfiguration.hashCode(),
        tbGetCustomerDetailsNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}, and {@link
   * TbGetCustomerDetailsNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}
   *   <li>{@link TbGetCustomerDetailsNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetCustomerDetailsNodeConfiguration.equals(Object)",
    "int TbGetCustomerDetailsNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration =
        new TbGetCustomerDetailsNodeConfiguration();

    // Act and Assert
    assertEquals(tbGetCustomerDetailsNodeConfiguration, tbGetCustomerDetailsNodeConfiguration);
    int expectedHashCodeResult = tbGetCustomerDetailsNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbGetCustomerDetailsNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetCustomerDetailsNodeConfiguration.equals(Object)",
    "int TbGetCustomerDetailsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetCustomerDetailsNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetCustomerDetailsNodeConfiguration.equals(Object)",
    "int TbGetCustomerDetailsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbGetCustomerDetailsNodeConfiguration tbGetCustomerDetailsNodeConfiguration =
        new TbGetCustomerDetailsNodeConfiguration();
    tbGetCustomerDetailsNodeConfiguration.setDetailsList(new ArrayList<>());

    // Act and Assert
    assertNotEquals(
        tbGetCustomerDetailsNodeConfiguration, new TbGetCustomerDetailsNodeConfiguration());
  }

  /**
   * Test {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetCustomerDetailsNodeConfiguration.equals(Object)",
    "int TbGetCustomerDetailsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbGetCustomerDetailsNodeConfiguration(), null);
  }

  /**
   * Test {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbGetCustomerDetailsNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbGetCustomerDetailsNodeConfiguration.equals(Object)",
    "int TbGetCustomerDetailsNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbGetCustomerDetailsNodeConfiguration(),
        "Different type to TbGetCustomerDetailsNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbGetCustomerDetailsNodeConfiguration}
   *   <li>{@link TbGetCustomerDetailsNodeConfiguration#toString()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbGetCustomerDetailsNodeConfiguration.<init>()",
    "java.lang.String TbGetCustomerDetailsNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbGetCustomerDetailsNodeConfiguration actualTbGetCustomerDetailsNodeConfiguration =
        new TbGetCustomerDetailsNodeConfiguration();

    // Assert
    assertEquals(
        "TbGetCustomerDetailsNodeConfiguration()",
        actualTbGetCustomerDetailsNodeConfiguration.toString());
    assertNull(actualTbGetCustomerDetailsNodeConfiguration.getDetailsList());
    assertNull(actualTbGetCustomerDetailsNodeConfiguration.getFetchTo());
  }
}
