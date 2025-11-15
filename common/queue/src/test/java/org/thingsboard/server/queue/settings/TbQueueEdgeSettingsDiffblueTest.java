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

class TbQueueEdgeSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueEdgeSettings#equals(Object)}
   *   <li>{@link TbQueueEdgeSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbQueueEdgeSettings tbQueueEdgeSettings = new TbQueueEdgeSettings();
    TbQueueEdgeSettings tbQueueEdgeSettings2 = new TbQueueEdgeSettings();

    // Act and Assert
    assertEquals(tbQueueEdgeSettings, tbQueueEdgeSettings2);
    int expectedHashCodeResult = tbQueueEdgeSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueEdgeSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueEdgeSettings#equals(Object)}
   *   <li>{@link TbQueueEdgeSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbQueueEdgeSettings tbQueueEdgeSettings = new TbQueueEdgeSettings();
    tbQueueEdgeSettings.setTopic("Topic");

    TbQueueEdgeSettings tbQueueEdgeSettings2 = new TbQueueEdgeSettings();
    tbQueueEdgeSettings2.setTopic("Topic");

    // Act and Assert
    assertEquals(tbQueueEdgeSettings, tbQueueEdgeSettings2);
    int expectedHashCodeResult = tbQueueEdgeSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueEdgeSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueEdgeSettings#equals(Object)}
   *   <li>{@link TbQueueEdgeSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbQueueEdgeSettings tbQueueEdgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertEquals(tbQueueEdgeSettings, tbQueueEdgeSettings);
    int expectedHashCodeResult = tbQueueEdgeSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueEdgeSettings.hashCode());
  }

  /**
   * Method under test: {@link TbQueueEdgeSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueEdgeSettings(), 1);
  }

  /**
   * Method under test: {@link TbQueueEdgeSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbQueueEdgeSettings tbQueueEdgeSettings = new TbQueueEdgeSettings();
    tbQueueEdgeSettings.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueEdgeSettings, new TbQueueEdgeSettings());
  }

  /**
   * Method under test: {@link TbQueueEdgeSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbQueueEdgeSettings tbQueueEdgeSettings = new TbQueueEdgeSettings();

    TbQueueEdgeSettings tbQueueEdgeSettings2 = new TbQueueEdgeSettings();
    tbQueueEdgeSettings2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueEdgeSettings, tbQueueEdgeSettings2);
  }

  /**
   * Method under test: {@link TbQueueEdgeSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueEdgeSettings(), null);
  }

  /**
   * Method under test: {@link TbQueueEdgeSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueEdgeSettings(), "Different type to TbQueueEdgeSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueEdgeSettings#setTopic(String)}
   *   <li>{@link TbQueueEdgeSettings#toString()}
   *   <li>{@link TbQueueEdgeSettings#getTopic()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbQueueEdgeSettings tbQueueEdgeSettings = new TbQueueEdgeSettings();

    // Act
    tbQueueEdgeSettings.setTopic("Topic");
    String actualToStringResult = tbQueueEdgeSettings.toString();

    // Assert that nothing has changed
    assertEquals("TbQueueEdgeSettings(topic=Topic)", actualToStringResult);
    assertEquals("Topic", tbQueueEdgeSettings.getTopic());
  }
}
