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

class TbQueueVersionControlSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueVersionControlSettings#equals(Object)}
   *   <li>{@link TbQueueVersionControlSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings = new TbQueueVersionControlSettings();
    TbQueueVersionControlSettings tbQueueVersionControlSettings2 = new TbQueueVersionControlSettings();

    // Act and Assert
    assertEquals(tbQueueVersionControlSettings, tbQueueVersionControlSettings2);
    int expectedHashCodeResult = tbQueueVersionControlSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueVersionControlSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueVersionControlSettings#equals(Object)}
   *   <li>{@link TbQueueVersionControlSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings = new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings.setTopic("Topic");

    TbQueueVersionControlSettings tbQueueVersionControlSettings2 = new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings2.setTopic("Topic");

    // Act and Assert
    assertEquals(tbQueueVersionControlSettings, tbQueueVersionControlSettings2);
    int expectedHashCodeResult = tbQueueVersionControlSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueVersionControlSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueVersionControlSettings#equals(Object)}
   *   <li>{@link TbQueueVersionControlSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings = new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings.setUsageStatsTopic("Usage Stats Topic");

    TbQueueVersionControlSettings tbQueueVersionControlSettings2 = new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings2.setUsageStatsTopic("Usage Stats Topic");

    // Act and Assert
    assertEquals(tbQueueVersionControlSettings, tbQueueVersionControlSettings2);
    int expectedHashCodeResult = tbQueueVersionControlSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueVersionControlSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueVersionControlSettings#equals(Object)}
   *   <li>{@link TbQueueVersionControlSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings = new TbQueueVersionControlSettings();

    // Act and Assert
    assertEquals(tbQueueVersionControlSettings, tbQueueVersionControlSettings);
    int expectedHashCodeResult = tbQueueVersionControlSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueVersionControlSettings.hashCode());
  }

  /**
   * Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueVersionControlSettings(), 1);
  }

  /**
   * Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings = new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueVersionControlSettings, new TbQueueVersionControlSettings());
  }

  /**
   * Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings = new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings.setUsageStatsTopic("Usage Stats Topic");

    // Act and Assert
    assertNotEquals(tbQueueVersionControlSettings, new TbQueueVersionControlSettings());
  }

  /**
   * Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings = new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings.setPartitions(1);

    // Act and Assert
    assertNotEquals(tbQueueVersionControlSettings, new TbQueueVersionControlSettings());
  }

  /**
   * Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings = new TbQueueVersionControlSettings();

    TbQueueVersionControlSettings tbQueueVersionControlSettings2 = new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueVersionControlSettings, tbQueueVersionControlSettings2);
  }

  /**
   * Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings = new TbQueueVersionControlSettings();

    TbQueueVersionControlSettings tbQueueVersionControlSettings2 = new TbQueueVersionControlSettings();
    tbQueueVersionControlSettings2.setUsageStatsTopic("Usage Stats Topic");

    // Act and Assert
    assertNotEquals(tbQueueVersionControlSettings, tbQueueVersionControlSettings2);
  }

  /**
   * Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueVersionControlSettings(), null);
  }

  /**
   * Method under test: {@link TbQueueVersionControlSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueVersionControlSettings(), "Different type to TbQueueVersionControlSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueVersionControlSettings#setPartitions(int)}
   *   <li>{@link TbQueueVersionControlSettings#setTopic(String)}
   *   <li>{@link TbQueueVersionControlSettings#setUsageStatsTopic(String)}
   *   <li>{@link TbQueueVersionControlSettings#toString()}
   *   <li>{@link TbQueueVersionControlSettings#getPartitions()}
   *   <li>{@link TbQueueVersionControlSettings#getTopic()}
   *   <li>{@link TbQueueVersionControlSettings#getUsageStatsTopic()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbQueueVersionControlSettings tbQueueVersionControlSettings = new TbQueueVersionControlSettings();

    // Act
    tbQueueVersionControlSettings.setPartitions(1);
    tbQueueVersionControlSettings.setTopic("Topic");
    tbQueueVersionControlSettings.setUsageStatsTopic("Usage Stats Topic");
    String actualToStringResult = tbQueueVersionControlSettings.toString();
    int actualPartitions = tbQueueVersionControlSettings.getPartitions();
    String actualTopic = tbQueueVersionControlSettings.getTopic();

    // Assert that nothing has changed
    assertEquals("TbQueueVersionControlSettings(topic=Topic, usageStatsTopic=Usage Stats Topic, partitions=1)",
        actualToStringResult);
    assertEquals("Topic", actualTopic);
    assertEquals("Usage Stats Topic", tbQueueVersionControlSettings.getUsageStatsTopic());
    assertEquals(1, actualPartitions);
  }
}
