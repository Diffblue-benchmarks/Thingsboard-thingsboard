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
package org.thingsboard.rule.engine.transform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbJsonPathNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbJsonPathNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbJsonPathNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbJsonPathNodeConfiguration TbJsonPathNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange, Act and Assert
    assertEquals("$", new TbJsonPathNodeConfiguration().defaultConfiguration().getJsonPath());
  }

  /**
   * Test {@link TbJsonPathNodeConfiguration#equals(Object)}, and {@link
   * TbJsonPathNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbJsonPathNodeConfiguration#equals(Object)}
   *   <li>{@link TbJsonPathNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsonPathNodeConfiguration.equals(Object)",
    "int TbJsonPathNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbJsonPathNodeConfiguration tbJsonPathNodeConfiguration = new TbJsonPathNodeConfiguration();
    TbJsonPathNodeConfiguration tbJsonPathNodeConfiguration2 = new TbJsonPathNodeConfiguration();

    // Act and Assert
    assertEquals(tbJsonPathNodeConfiguration, tbJsonPathNodeConfiguration2);
    assertEquals(tbJsonPathNodeConfiguration.hashCode(), tbJsonPathNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbJsonPathNodeConfiguration#equals(Object)}, and {@link
   * TbJsonPathNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbJsonPathNodeConfiguration#equals(Object)}
   *   <li>{@link TbJsonPathNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsonPathNodeConfiguration.equals(Object)",
    "int TbJsonPathNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbJsonPathNodeConfiguration tbJsonPathNodeConfiguration = new TbJsonPathNodeConfiguration();
    tbJsonPathNodeConfiguration.setJsonPath("Json Path");

    TbJsonPathNodeConfiguration tbJsonPathNodeConfiguration2 = new TbJsonPathNodeConfiguration();
    tbJsonPathNodeConfiguration2.setJsonPath("Json Path");

    // Act and Assert
    assertEquals(tbJsonPathNodeConfiguration, tbJsonPathNodeConfiguration2);
    assertEquals(tbJsonPathNodeConfiguration.hashCode(), tbJsonPathNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbJsonPathNodeConfiguration#equals(Object)}, and {@link
   * TbJsonPathNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbJsonPathNodeConfiguration#equals(Object)}
   *   <li>{@link TbJsonPathNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsonPathNodeConfiguration.equals(Object)",
    "int TbJsonPathNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbJsonPathNodeConfiguration tbJsonPathNodeConfiguration = new TbJsonPathNodeConfiguration();

    // Act and Assert
    assertEquals(tbJsonPathNodeConfiguration, tbJsonPathNodeConfiguration);
    int expectedHashCodeResult = tbJsonPathNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbJsonPathNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbJsonPathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbJsonPathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsonPathNodeConfiguration.equals(Object)",
    "int TbJsonPathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbJsonPathNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbJsonPathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbJsonPathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsonPathNodeConfiguration.equals(Object)",
    "int TbJsonPathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbJsonPathNodeConfiguration tbJsonPathNodeConfiguration = new TbJsonPathNodeConfiguration();
    tbJsonPathNodeConfiguration.setJsonPath("Json Path");

    // Act and Assert
    assertNotEquals(tbJsonPathNodeConfiguration, new TbJsonPathNodeConfiguration());
  }

  /**
   * Test {@link TbJsonPathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbJsonPathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsonPathNodeConfiguration.equals(Object)",
    "int TbJsonPathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbJsonPathNodeConfiguration tbJsonPathNodeConfiguration = new TbJsonPathNodeConfiguration();

    TbJsonPathNodeConfiguration tbJsonPathNodeConfiguration2 = new TbJsonPathNodeConfiguration();
    tbJsonPathNodeConfiguration2.setJsonPath("Json Path");

    // Act and Assert
    assertNotEquals(tbJsonPathNodeConfiguration, tbJsonPathNodeConfiguration2);
  }

  /**
   * Test {@link TbJsonPathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbJsonPathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsonPathNodeConfiguration.equals(Object)",
    "int TbJsonPathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbJsonPathNodeConfiguration(), null);
  }

  /**
   * Test {@link TbJsonPathNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbJsonPathNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbJsonPathNodeConfiguration.equals(Object)",
    "int TbJsonPathNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbJsonPathNodeConfiguration(), "Different type to TbJsonPathNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbJsonPathNodeConfiguration}
   *   <li>{@link TbJsonPathNodeConfiguration#setJsonPath(String)}
   *   <li>{@link TbJsonPathNodeConfiguration#toString()}
   *   <li>{@link TbJsonPathNodeConfiguration#getJsonPath()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbJsonPathNodeConfiguration.<init>()",
    "String TbJsonPathNodeConfiguration.getJsonPath()",
    "void TbJsonPathNodeConfiguration.setJsonPath(String)",
    "String TbJsonPathNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbJsonPathNodeConfiguration actualTbJsonPathNodeConfiguration =
        new TbJsonPathNodeConfiguration();
    actualTbJsonPathNodeConfiguration.setJsonPath("Json Path");
    String actualToStringResult = actualTbJsonPathNodeConfiguration.toString();

    // Assert
    assertEquals("Json Path", actualTbJsonPathNodeConfiguration.getJsonPath());
    assertEquals("TbJsonPathNodeConfiguration(jsonPath=Json Path)", actualToStringResult);
  }
}
