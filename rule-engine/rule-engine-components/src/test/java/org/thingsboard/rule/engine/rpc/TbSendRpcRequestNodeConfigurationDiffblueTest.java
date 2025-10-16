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
package org.thingsboard.rule.engine.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbSendRpcRequestNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbSendRpcRequestNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link TbSendRpcRequestNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "TbSendRpcRequestNodeConfiguration TbSendRpcRequestNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange, Act and Assert
    assertEquals(
        60, new TbSendRpcRequestNodeConfiguration().defaultConfiguration().getTimeoutInSeconds());
  }

  /**
   * Test {@link TbSendRpcRequestNodeConfiguration#equals(Object)}, and {@link
   * TbSendRpcRequestNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSendRpcRequestNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendRpcRequestNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRpcRequestNodeConfiguration.equals(Object)",
    "int TbSendRpcRequestNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbSendRpcRequestNodeConfiguration tbSendRpcRequestNodeConfiguration =
        new TbSendRpcRequestNodeConfiguration();
    TbSendRpcRequestNodeConfiguration tbSendRpcRequestNodeConfiguration2 =
        new TbSendRpcRequestNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRpcRequestNodeConfiguration, tbSendRpcRequestNodeConfiguration2);
    assertEquals(
        tbSendRpcRequestNodeConfiguration.hashCode(),
        tbSendRpcRequestNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSendRpcRequestNodeConfiguration#equals(Object)}, and {@link
   * TbSendRpcRequestNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSendRpcRequestNodeConfiguration#equals(Object)}
   *   <li>{@link TbSendRpcRequestNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRpcRequestNodeConfiguration.equals(Object)",
    "int TbSendRpcRequestNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbSendRpcRequestNodeConfiguration tbSendRpcRequestNodeConfiguration =
        new TbSendRpcRequestNodeConfiguration();

    // Act and Assert
    assertEquals(tbSendRpcRequestNodeConfiguration, tbSendRpcRequestNodeConfiguration);
    int expectedHashCodeResult = tbSendRpcRequestNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSendRpcRequestNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbSendRpcRequestNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRpcRequestNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRpcRequestNodeConfiguration.equals(Object)",
    "int TbSendRpcRequestNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendRpcRequestNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbSendRpcRequestNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRpcRequestNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRpcRequestNodeConfiguration.equals(Object)",
    "int TbSendRpcRequestNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbSendRpcRequestNodeConfiguration tbSendRpcRequestNodeConfiguration =
        new TbSendRpcRequestNodeConfiguration();
    tbSendRpcRequestNodeConfiguration.setTimeoutInSeconds(10);

    // Act and Assert
    assertNotEquals(tbSendRpcRequestNodeConfiguration, new TbSendRpcRequestNodeConfiguration());
  }

  /**
   * Test {@link TbSendRpcRequestNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRpcRequestNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRpcRequestNodeConfiguration.equals(Object)",
    "int TbSendRpcRequestNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSendRpcRequestNodeConfiguration(), null);
  }

  /**
   * Test {@link TbSendRpcRequestNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSendRpcRequestNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbSendRpcRequestNodeConfiguration.equals(Object)",
    "int TbSendRpcRequestNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbSendRpcRequestNodeConfiguration(),
        "Different type to TbSendRpcRequestNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbSendRpcRequestNodeConfiguration}
   *   <li>{@link TbSendRpcRequestNodeConfiguration#setTimeoutInSeconds(int)}
   *   <li>{@link TbSendRpcRequestNodeConfiguration#toString()}
   *   <li>{@link TbSendRpcRequestNodeConfiguration#getTimeoutInSeconds()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbSendRpcRequestNodeConfiguration.<init>()",
    "int TbSendRpcRequestNodeConfiguration.getTimeoutInSeconds()",
    "void TbSendRpcRequestNodeConfiguration.setTimeoutInSeconds(int)",
    "String TbSendRpcRequestNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbSendRpcRequestNodeConfiguration actualTbSendRpcRequestNodeConfiguration =
        new TbSendRpcRequestNodeConfiguration();
    actualTbSendRpcRequestNodeConfiguration.setTimeoutInSeconds(10);
    String actualToStringResult = actualTbSendRpcRequestNodeConfiguration.toString();

    // Assert
    assertEquals("TbSendRpcRequestNodeConfiguration(timeoutInSeconds=10)", actualToStringResult);
    assertEquals(10, actualTbSendRpcRequestNodeConfiguration.getTimeoutInSeconds());
  }
}
