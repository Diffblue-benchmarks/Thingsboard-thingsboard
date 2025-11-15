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
package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class TbActorSystemSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbActorSystemSettings#equals(Object)}
   *   <li>{@link TbActorSystemSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbActorSystemSettings tbActorSystemSettings = new TbActorSystemSettings(1, 3, 3);
    TbActorSystemSettings tbActorSystemSettings2 = new TbActorSystemSettings(1, 3, 3);

    // Act and Assert
    assertEquals(tbActorSystemSettings, tbActorSystemSettings2);
    int expectedHashCodeResult = tbActorSystemSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbActorSystemSettings2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbActorSystemSettings#equals(Object)}
   *   <li>{@link TbActorSystemSettings#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbActorSystemSettings tbActorSystemSettings = new TbActorSystemSettings(1, 3, 3);

    // Act and Assert
    assertEquals(tbActorSystemSettings, tbActorSystemSettings);
    int expectedHashCodeResult = tbActorSystemSettings.hashCode();
    assertEquals(expectedHashCodeResult, tbActorSystemSettings.hashCode());
  }

  /**
   * Method under test: {@link TbActorSystemSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbActorSystemSettings tbActorSystemSettings = new TbActorSystemSettings(3, 3, 3);

    // Act and Assert
    assertNotEquals(tbActorSystemSettings, new TbActorSystemSettings(1, 3, 3));
  }

  /**
   * Method under test: {@link TbActorSystemSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbActorSystemSettings tbActorSystemSettings = new TbActorSystemSettings(1, 1, 3);

    // Act and Assert
    assertNotEquals(tbActorSystemSettings, new TbActorSystemSettings(1, 3, 3));
  }

  /**
   * Method under test: {@link TbActorSystemSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbActorSystemSettings tbActorSystemSettings = new TbActorSystemSettings(1, 3, 1);

    // Act and Assert
    assertNotEquals(tbActorSystemSettings, new TbActorSystemSettings(1, 3, 3));
  }

  /**
   * Method under test: {@link TbActorSystemSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbActorSystemSettings(1, 3, 3), null);
  }

  /**
   * Method under test: {@link TbActorSystemSettings#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbActorSystemSettings(1, 3, 3), "Different type to TbActorSystemSettings");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbActorSystemSettings#TbActorSystemSettings(int, int, int)}
   *   <li>{@link TbActorSystemSettings#toString()}
   *   <li>{@link TbActorSystemSettings#getActorThroughput()}
   *   <li>{@link TbActorSystemSettings#getMaxActorInitAttempts()}
   *   <li>{@link TbActorSystemSettings#getSchedulerPoolSize()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TbActorSystemSettings actualTbActorSystemSettings = new TbActorSystemSettings(1, 3, 3);
    String actualToStringResult = actualTbActorSystemSettings.toString();
    int actualActorThroughput = actualTbActorSystemSettings.getActorThroughput();
    int actualMaxActorInitAttempts = actualTbActorSystemSettings.getMaxActorInitAttempts();

    // Assert
    assertEquals("TbActorSystemSettings(actorThroughput=1, schedulerPoolSize=3, maxActorInitAttempts=3)",
        actualToStringResult);
    assertEquals(1, actualActorThroughput);
    assertEquals(3, actualMaxActorInitAttempts);
    assertEquals(3, actualTbActorSystemSettings.getSchedulerPoolSize());
  }
}
