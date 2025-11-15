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
import org.junit.jupiter.api.Test;

class TbQueueRuleEngineSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueRuleEngineSettings#equals(Object)}
   *   <li>{@link TbQueueRuleEngineSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings2 = new TbQueueRuleEngineSettings();

    // Act and Assert
    assertEquals(tbQueueRuleEngineSettings, tbQueueRuleEngineSettings2);
    int expectedHashCodeResult = tbQueueRuleEngineSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueRuleEngineSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueRuleEngineSettings#equals(Object)}
   *   <li>{@link TbQueueRuleEngineSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();
    tbQueueRuleEngineSettings.setTopic("Topic");

    TbQueueRuleEngineSettings tbQueueRuleEngineSettings2 = new TbQueueRuleEngineSettings();
    tbQueueRuleEngineSettings2.setTopic("Topic");

    // Act and Assert
    assertEquals(tbQueueRuleEngineSettings, tbQueueRuleEngineSettings2);
    int expectedHashCodeResult = tbQueueRuleEngineSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueRuleEngineSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueRuleEngineSettings#equals(Object)}
   *   <li>{@link TbQueueRuleEngineSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();

    // Act and Assert
    assertEquals(tbQueueRuleEngineSettings, tbQueueRuleEngineSettings);
    int expectedHashCodeResult = tbQueueRuleEngineSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueRuleEngineSettings.hashCode());
  }

  /**
   * Method under test: {@link TbQueueRuleEngineSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueRuleEngineSettings(), 1);
  }

  /**
   * Method under test: {@link TbQueueRuleEngineSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();
    tbQueueRuleEngineSettings.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueRuleEngineSettings, new TbQueueRuleEngineSettings());
  }

  /**
   * Method under test: {@link TbQueueRuleEngineSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();

    TbQueueRuleEngineSettings tbQueueRuleEngineSettings2 = new TbQueueRuleEngineSettings();
    tbQueueRuleEngineSettings2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueRuleEngineSettings, tbQueueRuleEngineSettings2);
  }

  /**
   * Method under test: {@link TbQueueRuleEngineSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueRuleEngineSettings(), null);
  }

  /**
   * Method under test: {@link TbQueueRuleEngineSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueRuleEngineSettings(), "Different type to TbQueueRuleEngineSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueRuleEngineSettings#setTopic(String)}
   *   <li>{@link TbQueueRuleEngineSettings#toString()}
   *   <li>{@link TbQueueRuleEngineSettings#getTopic()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbQueueRuleEngineSettings tbQueueRuleEngineSettings = new TbQueueRuleEngineSettings();

    // Act
    tbQueueRuleEngineSettings.setTopic("Topic");
    String actualToStringResult = tbQueueRuleEngineSettings.toString();

    // Assert that nothing has changed
    assertEquals("TbQueueRuleEngineSettings(topic=Topic)", actualToStringResult);
    assertEquals("Topic", tbQueueRuleEngineSettings.getTopic());
  }
}
