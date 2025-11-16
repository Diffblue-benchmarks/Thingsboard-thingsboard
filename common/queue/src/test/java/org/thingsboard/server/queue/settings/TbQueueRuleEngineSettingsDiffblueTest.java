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
package org.thingsboard.server.queue.settings;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbQueueRuleEngineSettingsDiffblueTest {
  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}, and {@link
   * TbQueueRuleEngineSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueRuleEngineSettings#equals(Object)}
   *   <li>{@link TbQueueRuleEngineSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbQueueRuleEngineSettings.equals(Object)",
    "int TbQueueRuleEngineSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings2 = new TbQueueRuleEngineSettings();

    // Act and Assert
    assertEquals(tbQueueRuleEngineSettings, tbQueueRuleEngineSettings2);
    assertEquals(tbQueueRuleEngineSettings.hashCode(), tbQueueRuleEngineSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}, and {@link
   * TbQueueRuleEngineSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueRuleEngineSettings#equals(Object)}
   *   <li>{@link TbQueueRuleEngineSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbQueueRuleEngineSettings.equals(Object)",
    "int TbQueueRuleEngineSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();
    tbQueueRuleEngineSettings.setTopic("Topic");

    TbQueueRuleEngineSettings tbQueueRuleEngineSettings2 = new TbQueueRuleEngineSettings();
    tbQueueRuleEngineSettings2.setTopic("Topic");

    // Act and Assert
    assertEquals(tbQueueRuleEngineSettings, tbQueueRuleEngineSettings2);
    assertEquals(tbQueueRuleEngineSettings.hashCode(), tbQueueRuleEngineSettings2.hashCode());
  }

  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}, and {@link
   * TbQueueRuleEngineSettings#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueRuleEngineSettings#equals(Object)}
   *   <li>{@link TbQueueRuleEngineSettings#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbQueueRuleEngineSettings.equals(Object)",
    "int TbQueueRuleEngineSettings.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();

    // Act and Assert
    assertEquals(tbQueueRuleEngineSettings, tbQueueRuleEngineSettings);
    int expectedHashCodeResult = tbQueueRuleEngineSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueRuleEngineSettings.hashCode());
  }

  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRuleEngineSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbQueueRuleEngineSettings.equals(Object)",
    "int TbQueueRuleEngineSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueRuleEngineSettings(), 1);
  }

  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRuleEngineSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbQueueRuleEngineSettings.equals(Object)",
    "int TbQueueRuleEngineSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();
    tbQueueRuleEngineSettings.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueRuleEngineSettings, new TbQueueRuleEngineSettings());
  }

  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRuleEngineSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbQueueRuleEngineSettings.equals(Object)",
    "int TbQueueRuleEngineSettings.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();

    TbQueueRuleEngineSettings tbQueueRuleEngineSettings2 = new TbQueueRuleEngineSettings();
    tbQueueRuleEngineSettings2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueRuleEngineSettings, tbQueueRuleEngineSettings2);
  }

  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRuleEngineSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbQueueRuleEngineSettings.equals(Object)",
    "int TbQueueRuleEngineSettings.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueRuleEngineSettings(), null);
  }

  /**
   * Test {@link TbQueueRuleEngineSettings#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbQueueRuleEngineSettings#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TbQueueRuleEngineSettings.equals(Object)",
    "int TbQueueRuleEngineSettings.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueRuleEngineSettings(), "Different type to TbQueueRuleEngineSettings");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbQueueRuleEngineSettings#setTopic(String)}
   *   <li>{@link TbQueueRuleEngineSettings#toString()}
   *   <li>{@link TbQueueRuleEngineSettings#getTopic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String TbQueueRuleEngineSettings.getTopic()",
    "void TbQueueRuleEngineSettings.setTopic(String)",
    "String TbQueueRuleEngineSettings.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();

    // Act
    tbQueueRuleEngineSettings.setTopic("Topic");
    String actualToStringResult = tbQueueRuleEngineSettings.toString();

    // Assert
    assertEquals("TbQueueRuleEngineSettings(topic=Topic)", actualToStringResult);
    assertEquals("Topic", tbQueueRuleEngineSettings.getTopic());
  }
}
