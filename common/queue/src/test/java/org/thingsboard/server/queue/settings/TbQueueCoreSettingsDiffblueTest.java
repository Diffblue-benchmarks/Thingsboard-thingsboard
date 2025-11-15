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

class TbQueueCoreSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueCoreSettings#equals(Object)}
   *   <li>{@link TbQueueCoreSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();

    // Act and Assert
    assertEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
    int expectedHashCodeResult = tbQueueCoreSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueCoreSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueCoreSettings#equals(Object)}
   *   <li>{@link TbQueueCoreSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setTopic("Topic");

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setTopic("Topic");

    // Act and Assert
    assertEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
    int expectedHashCodeResult = tbQueueCoreSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueCoreSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueCoreSettings#equals(Object)}
   *   <li>{@link TbQueueCoreSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setOtaPackageTopic("java.text");

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setOtaPackageTopic("java.text");

    // Act and Assert
    assertEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
    int expectedHashCodeResult = tbQueueCoreSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueCoreSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueCoreSettings#equals(Object)}
   *   <li>{@link TbQueueCoreSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setUsageStatsTopic("Usage Stats Topic");

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setUsageStatsTopic("Usage Stats Topic");

    // Act and Assert
    assertEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
    int expectedHashCodeResult = tbQueueCoreSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueCoreSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueCoreSettings#equals(Object)}
   *   <li>{@link TbQueueCoreSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setHousekeeperTopic("Housekeeper Topic");

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setHousekeeperTopic("Housekeeper Topic");

    // Act and Assert
    assertEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
    int expectedHashCodeResult = tbQueueCoreSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueCoreSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueCoreSettings#equals(Object)}
   *   <li>{@link TbQueueCoreSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setHousekeeperReprocessingTopic("Housekeeper Reprocessing Topic");

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setHousekeeperReprocessingTopic("Housekeeper Reprocessing Topic");

    // Act and Assert
    assertEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
    int expectedHashCodeResult = tbQueueCoreSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueCoreSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueCoreSettings#equals(Object)}
   *   <li>{@link TbQueueCoreSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();

    // Act and Assert
    assertEquals(tbQueueCoreSettings, tbQueueCoreSettings);
    int expectedHashCodeResult = tbQueueCoreSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbQueueCoreSettings.hashCode());
  }

  /**
   * Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueCoreSettings(), 1);
  }

  /**
   * Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, new TbQueueCoreSettings());
  }

  /**
   * Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setOtaPackageTopic("java.text");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, new TbQueueCoreSettings());
  }

  /**
   * Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setUsageStatsTopic("Usage Stats Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, new TbQueueCoreSettings());
  }

  /**
   * Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setHousekeeperTopic("Housekeeper Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, new TbQueueCoreSettings());
  }

  /**
   * Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setHousekeeperReprocessingTopic("Housekeeper Reprocessing Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, new TbQueueCoreSettings());
  }

  /**
   * Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();
    tbQueueCoreSettings.setPartitions(1);

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, new TbQueueCoreSettings());
  }

  /**
   * Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setTopic("Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
  }

  /**
   * Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setOtaPackageTopic("java.text");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
  }

  /**
   * Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setUsageStatsTopic("Usage Stats Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
  }

  /**
   * Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setHousekeeperTopic("Housekeeper Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
  }

  /**
   * Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();

    TbQueueCoreSettings tbQueueCoreSettings2 = new TbQueueCoreSettings();
    tbQueueCoreSettings2.setHousekeeperReprocessingTopic("Housekeeper Reprocessing Topic");

    // Act and Assert
    assertNotEquals(tbQueueCoreSettings, tbQueueCoreSettings2);
  }

  /**
   * Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueCoreSettings(), null);
  }

  /**
   * Method under test: {@link TbQueueCoreSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbQueueCoreSettings(), "Different type to TbQueueCoreSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbQueueCoreSettings#setHousekeeperReprocessingTopic(String)}
   *   <li>{@link TbQueueCoreSettings#setHousekeeperTopic(String)}
   *   <li>{@link TbQueueCoreSettings#setOtaPackageTopic(String)}
   *   <li>{@link TbQueueCoreSettings#setPartitions(int)}
   *   <li>{@link TbQueueCoreSettings#setTopic(String)}
   *   <li>{@link TbQueueCoreSettings#setUsageStatsTopic(String)}
   *   <li>{@link TbQueueCoreSettings#toString()}
   *   <li>{@link TbQueueCoreSettings#getHousekeeperReprocessingTopic()}
   *   <li>{@link TbQueueCoreSettings#getHousekeeperTopic()}
   *   <li>{@link TbQueueCoreSettings#getOtaPackageTopic()}
   *   <li>{@link TbQueueCoreSettings#getPartitions()}
   *   <li>{@link TbQueueCoreSettings#getTopic()}
   *   <li>{@link TbQueueCoreSettings#getUsageStatsTopic()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbQueueCoreSettings tbQueueCoreSettings = new TbQueueCoreSettings();

    // Act
    tbQueueCoreSettings.setHousekeeperReprocessingTopic("Housekeeper Reprocessing Topic");
    tbQueueCoreSettings.setHousekeeperTopic("Housekeeper Topic");
    tbQueueCoreSettings.setOtaPackageTopic("java.text");
    tbQueueCoreSettings.setPartitions(1);
    tbQueueCoreSettings.setTopic("Topic");
    tbQueueCoreSettings.setUsageStatsTopic("Usage Stats Topic");
    String actualToStringResult = tbQueueCoreSettings.toString();
    String actualHousekeeperReprocessingTopic = tbQueueCoreSettings.getHousekeeperReprocessingTopic();
    String actualHousekeeperTopic = tbQueueCoreSettings.getHousekeeperTopic();
    String actualOtaPackageTopic = tbQueueCoreSettings.getOtaPackageTopic();
    int actualPartitions = tbQueueCoreSettings.getPartitions();
    String actualTopic = tbQueueCoreSettings.getTopic();

    // Assert that nothing has changed
    assertEquals("Housekeeper Reprocessing Topic", actualHousekeeperReprocessingTopic);
    assertEquals("Housekeeper Topic", actualHousekeeperTopic);
    assertEquals("TbQueueCoreSettings(topic=Topic, otaPackageTopic=java.text, usageStatsTopic=Usage Stats Topic,"
        + " housekeeperTopic=Housekeeper Topic, housekeeperReprocessingTopic=Housekeeper Reprocessing Topic,"
        + " partitions=1)", actualToStringResult);
    assertEquals("Topic", actualTopic);
    assertEquals("Usage Stats Topic", tbQueueCoreSettings.getUsageStatsTopic());
    assertEquals("java.text", actualOtaPackageTopic);
    assertEquals(1, actualPartitions);
  }
}
