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
package org.thingsboard.server.common.data.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class StatisticsEventFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEventFilter#equals(Object)}
   *   <li>{@link StatisticsEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(statisticsEventFilter, statisticsEventFilter2);
    int expectedHashCodeResult = statisticsEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventFilter2.hashCode());
  }

  /**
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty() {
    // Arrange, Act and Assert
    assertFalse((new StatisticsEventFilter()).isNotEmpty());
  }

  /**
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty2() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(null);
    statisticsEventFilter.setMaxMessagesProcessed(null);
    statisticsEventFilter.setMaxErrorsOccurred(null);
    statisticsEventFilter.setServer("");

    // Act and Assert
    assertFalse(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty3() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(null);
    statisticsEventFilter.setMaxMessagesProcessed(null);
    statisticsEventFilter.setMaxErrorsOccurred(null);
    statisticsEventFilter.setServer("foo");

    // Act and Assert
    assertTrue(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty4() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(null);
    statisticsEventFilter.setMaxMessagesProcessed(null);
    statisticsEventFilter.setMaxErrorsOccurred(0);
    statisticsEventFilter.setServer(null);

    // Act and Assert
    assertFalse(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty5() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(null);
    statisticsEventFilter.setMaxMessagesProcessed(null);
    statisticsEventFilter.setMaxErrorsOccurred(1);
    statisticsEventFilter.setServer(null);

    // Act and Assert
    assertTrue(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty6() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(null);
    statisticsEventFilter.setMaxMessagesProcessed(0);
    statisticsEventFilter.setMaxErrorsOccurred(null);
    statisticsEventFilter.setServer(null);

    // Act and Assert
    assertFalse(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty7() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(null);
    statisticsEventFilter.setMaxMessagesProcessed(1);
    statisticsEventFilter.setMaxErrorsOccurred(null);
    statisticsEventFilter.setServer(null);

    // Act and Assert
    assertTrue(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty8() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(0);
    statisticsEventFilter.setMaxMessagesProcessed(null);
    statisticsEventFilter.setMaxErrorsOccurred(null);
    statisticsEventFilter.setServer(null);

    // Act and Assert
    assertFalse(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty9() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMinMessagesProcessed(1);

    // Act and Assert
    assertTrue(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty10() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMinMessagesProcessed(0);

    // Act and Assert
    assertFalse(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link StatisticsEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty11() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(1);
    statisticsEventFilter.setMaxMessagesProcessed(null);
    statisticsEventFilter.setMaxErrorsOccurred(null);
    statisticsEventFilter.setServer("");

    // Act and Assert
    assertTrue(statisticsEventFilter.isNotEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEventFilter#equals(Object)}
   *   <li>{@link StatisticsEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(null);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(null);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(statisticsEventFilter, statisticsEventFilter2);
    int expectedHashCodeResult = statisticsEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEventFilter#equals(Object)}
   *   <li>{@link StatisticsEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(null);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(statisticsEventFilter, statisticsEventFilter2);
    int expectedHashCodeResult = statisticsEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEventFilter#equals(Object)}
   *   <li>{@link StatisticsEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(null);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(null);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(statisticsEventFilter, statisticsEventFilter2);
    int expectedHashCodeResult = statisticsEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEventFilter#equals(Object)}
   *   <li>{@link StatisticsEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(null);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertEquals(statisticsEventFilter, statisticsEventFilter2);
    int expectedHashCodeResult = statisticsEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEventFilter#equals(Object)}
   *   <li>{@link StatisticsEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer(null);

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer(null);

    // Act and Assert
    assertEquals(statisticsEventFilter, statisticsEventFilter2);
    int expectedHashCodeResult = statisticsEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link StatisticsEventFilter#equals(Object)}
   *   <li>{@link StatisticsEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    // Act and Assert
    assertEquals(statisticsEventFilter, statisticsEventFilter);
    int expectedHashCodeResult = statisticsEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, statisticsEventFilter.hashCode());
  }

  /**
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(3);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(null);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(1);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(null);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(null);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(3);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(null);
    statisticsEventFilter.setServer("Server");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer(null);

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("org.thingsboard.server.common.data.event.StatisticsEventFilter");

    StatisticsEventFilter statisticsEventFilter2 = new StatisticsEventFilter();
    statisticsEventFilter2.setMaxErrorsOccurred(-1);
    statisticsEventFilter2.setMaxMessagesProcessed(3);
    statisticsEventFilter2.setMinErrorsOccurred(-1);
    statisticsEventFilter2.setMinMessagesProcessed(1);
    statisticsEventFilter2.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, statisticsEventFilter2);
  }

  /**
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, null);
  }

  /**
   * Method under test: {@link StatisticsEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    StatisticsEventFilter statisticsEventFilter = new StatisticsEventFilter();
    statisticsEventFilter.setMaxErrorsOccurred(-1);
    statisticsEventFilter.setMaxMessagesProcessed(3);
    statisticsEventFilter.setMinErrorsOccurred(-1);
    statisticsEventFilter.setMinMessagesProcessed(1);
    statisticsEventFilter.setServer("Server");

    // Act and Assert
    assertNotEquals(statisticsEventFilter, "Different type to StatisticsEventFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link StatisticsEventFilter}
   *   <li>{@link StatisticsEventFilter#setMaxErrorsOccurred(Integer)}
   *   <li>{@link StatisticsEventFilter#setMaxMessagesProcessed(Integer)}
   *   <li>{@link StatisticsEventFilter#setMinErrorsOccurred(Integer)}
   *   <li>{@link StatisticsEventFilter#setMinMessagesProcessed(Integer)}
   *   <li>{@link StatisticsEventFilter#setServer(String)}
   *   <li>{@link StatisticsEventFilter#toString()}
   *   <li>{@link StatisticsEventFilter#getEventType()}
   *   <li>{@link StatisticsEventFilter#getMaxErrorsOccurred()}
   *   <li>{@link StatisticsEventFilter#getMaxMessagesProcessed()}
   *   <li>{@link StatisticsEventFilter#getMinErrorsOccurred()}
   *   <li>{@link StatisticsEventFilter#getMinMessagesProcessed()}
   *   <li>{@link StatisticsEventFilter#getServer()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    StatisticsEventFilter actualStatisticsEventFilter = new StatisticsEventFilter();
    actualStatisticsEventFilter.setMaxErrorsOccurred(-1);
    actualStatisticsEventFilter.setMaxMessagesProcessed(3);
    actualStatisticsEventFilter.setMinErrorsOccurred(-1);
    actualStatisticsEventFilter.setMinMessagesProcessed(1);
    actualStatisticsEventFilter.setServer("Server");
    String actualToStringResult = actualStatisticsEventFilter.toString();
    EventType actualEventType = actualStatisticsEventFilter.getEventType();
    Integer actualMaxErrorsOccurred = actualStatisticsEventFilter.getMaxErrorsOccurred();
    Integer actualMaxMessagesProcessed = actualStatisticsEventFilter.getMaxMessagesProcessed();
    Integer actualMinErrorsOccurred = actualStatisticsEventFilter.getMinErrorsOccurred();
    Integer actualMinMessagesProcessed = actualStatisticsEventFilter.getMinMessagesProcessed();

    // Assert that nothing has changed
    assertEquals("Server", actualStatisticsEventFilter.getServer());
    assertEquals(
        "StatisticsEventFilter(server=Server, minMessagesProcessed=1, maxMessagesProcessed=3, minErrorsOccurred=-1,"
            + " maxErrorsOccurred=-1)",
        actualToStringResult);
    assertEquals(-1, actualMaxErrorsOccurred.intValue());
    assertEquals(-1, actualMinErrorsOccurred.intValue());
    assertEquals(1, actualMinMessagesProcessed.intValue());
    assertEquals(3, actualMaxMessagesProcessed.intValue());
    assertEquals(EventType.STATS, actualEventType);
  }
}
