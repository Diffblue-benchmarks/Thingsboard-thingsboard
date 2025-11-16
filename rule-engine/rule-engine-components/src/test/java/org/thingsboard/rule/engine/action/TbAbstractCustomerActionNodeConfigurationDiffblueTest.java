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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TbAbstractCustomerActionNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbAbstractCustomerActionNodeConfiguration#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@code Other}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName("Test canEqual(Object); when 'Other'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbAbstractCustomerActionNodeConfiguration.canEqual(Object)"})
  void testCanEqual_whenOther_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new TbAssignToCustomerNodeConfiguration().canEqual("Other"));
  }

  /**
   * Test {@link TbAbstractCustomerActionNodeConfiguration#canEqual(Object)}.
   *
   * <ul>
   *   <li>When {@link TbAssignToCustomerNodeConfiguration} (default constructor).
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNodeConfiguration#canEqual(Object)}
   */
  @Test
  @DisplayName(
      "Test canEqual(Object); when TbAssignToCustomerNodeConfiguration (default constructor); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean TbAbstractCustomerActionNodeConfiguration.canEqual(Object)"})
  void testCanEqual_whenTbAssignToCustomerNodeConfiguration_thenReturnTrue() {
    // Arrange
    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration =
        new TbAssignToCustomerNodeConfiguration();

    // Act and Assert
    assertTrue(
        tbAssignToCustomerNodeConfiguration.canEqual(new TbAssignToCustomerNodeConfiguration()));
  }

  /**
   * Test {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}, and {@link
   * TbAbstractCustomerActionNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractCustomerActionNodeConfiguration.equals(Object)",
    "int TbAbstractCustomerActionNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration =
        new TbAssignToCustomerNodeConfiguration();
    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration2 =
        new TbAssignToCustomerNodeConfiguration();

    // Act and Assert
    assertEquals(tbAssignToCustomerNodeConfiguration, tbAssignToCustomerNodeConfiguration2);
    assertEquals(
        tbAssignToCustomerNodeConfiguration.hashCode(),
        tbAssignToCustomerNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}, and {@link
   * TbAbstractCustomerActionNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractCustomerActionNodeConfiguration.equals(Object)",
    "int TbAbstractCustomerActionNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration =
        new TbAssignToCustomerNodeConfiguration();

    // Act and Assert
    assertEquals(tbAssignToCustomerNodeConfiguration, tbAssignToCustomerNodeConfiguration);
    int expectedHashCodeResult = tbAssignToCustomerNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbAssignToCustomerNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractCustomerActionNodeConfiguration.equals(Object)",
    "int TbAbstractCustomerActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbAssignToCustomerNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractCustomerActionNodeConfiguration.equals(Object)",
    "int TbAbstractCustomerActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration =
        new TbAssignToCustomerNodeConfiguration();

    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration2 =
        mock(TbAssignToCustomerNodeConfiguration.class);
    when(tbAssignToCustomerNodeConfiguration2.isCreateCustomerIfNotExists()).thenReturn(true);
    when(tbAssignToCustomerNodeConfiguration2.getCustomerNamePattern())
        .thenReturn("Customer Name Pattern");
    when(tbAssignToCustomerNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbAssignToCustomerNodeConfiguration, tbAssignToCustomerNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractCustomerActionNodeConfiguration.equals(Object)",
    "int TbAbstractCustomerActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration =
        new TbAssignToCustomerNodeConfiguration();
    tbAssignToCustomerNodeConfiguration.setCustomerNamePattern("Customer Name Pattern");

    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration2 =
        mock(TbAssignToCustomerNodeConfiguration.class);
    when(tbAssignToCustomerNodeConfiguration2.isCreateCustomerIfNotExists()).thenReturn(true);
    when(tbAssignToCustomerNodeConfiguration2.getCustomerNamePattern())
        .thenReturn("Customer Name Pattern");
    when(tbAssignToCustomerNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbAssignToCustomerNodeConfiguration, tbAssignToCustomerNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractCustomerActionNodeConfiguration.equals(Object)",
    "int TbAbstractCustomerActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration =
        new TbAssignToCustomerNodeConfiguration();
    tbAssignToCustomerNodeConfiguration.setCustomerNamePattern(
        "org.thingsboard.rule.engine.action.TbAbstractCustomerActionNodeConfiguration");

    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration2 =
        mock(TbAssignToCustomerNodeConfiguration.class);
    when(tbAssignToCustomerNodeConfiguration2.isCreateCustomerIfNotExists()).thenReturn(true);
    when(tbAssignToCustomerNodeConfiguration2.getCustomerNamePattern())
        .thenReturn("Customer Name Pattern");
    when(tbAssignToCustomerNodeConfiguration2.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(tbAssignToCustomerNodeConfiguration, tbAssignToCustomerNodeConfiguration2);
  }

  /**
   * Test {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractCustomerActionNodeConfiguration.equals(Object)",
    "int TbAbstractCustomerActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbAssignToCustomerNodeConfiguration(), null);
  }

  /**
   * Test {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbAbstractCustomerActionNodeConfiguration.equals(Object)",
    "int TbAbstractCustomerActionNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbAssignToCustomerNodeConfiguration(),
        "Different type to TbAbstractCustomerActionNodeConfiguration");
  }

  /**
   * Test {@link TbAbstractCustomerActionNodeConfiguration#getCustomerNamePattern()}.
   *
   * <p>Method under test: {@link
   * TbAbstractCustomerActionNodeConfiguration#getCustomerNamePattern()}
   */
  @Test
  @DisplayName("Test getCustomerNamePattern()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbAbstractCustomerActionNodeConfiguration.getCustomerNamePattern()"})
  void testGetCustomerNamePattern() {
    // Arrange, Act and Assert
    assertNull(new TbAssignToCustomerNodeConfiguration().getCustomerNamePattern());
  }

  /**
   * Test {@link TbAbstractCustomerActionNodeConfiguration#setCustomerNamePattern(String)}.
   *
   * <p>Method under test: {@link
   * TbAbstractCustomerActionNodeConfiguration#setCustomerNamePattern(String)}
   */
  @Test
  @DisplayName("Test setCustomerNamePattern(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbAbstractCustomerActionNodeConfiguration.setCustomerNamePattern(String)"
  })
  void testSetCustomerNamePattern() {
    // Arrange
    TbAssignToCustomerNodeConfiguration tbAssignToCustomerNodeConfiguration =
        new TbAssignToCustomerNodeConfiguration();

    // Act
    tbAssignToCustomerNodeConfiguration.setCustomerNamePattern("Customer Name Pattern");

    // Assert
    assertEquals(
        "Customer Name Pattern", tbAssignToCustomerNodeConfiguration.getCustomerNamePattern());
  }

  /**
   * Test {@link TbAbstractCustomerActionNodeConfiguration#toString()}.
   *
   * <p>Method under test: {@link TbAbstractCustomerActionNodeConfiguration#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbAbstractCustomerActionNodeConfiguration.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "TbAssignToCustomerNodeConfiguration(createCustomerIfNotExists=false)",
        new TbAssignToCustomerNodeConfiguration().toString());
  }
}
