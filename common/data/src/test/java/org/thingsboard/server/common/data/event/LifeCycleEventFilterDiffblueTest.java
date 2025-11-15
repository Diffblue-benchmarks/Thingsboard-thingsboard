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

class LifeCycleEventFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LifeCycleEventFilter#equals(Object)}
   *   <li>{@link LifeCycleEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
    int expectedHashCodeResult = lifeCycleEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, lifeCycleEventFilter2.hashCode());
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty() {
    // Arrange, Act and Assert
    assertFalse((new LifeCycleEventFilter()).isNotEmpty());
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty2() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setServer(null);
    lifeCycleEventFilter.setErrorStr(null);
    lifeCycleEventFilter.setEvent(null);
    lifeCycleEventFilter.setStatus("");

    // Act and Assert
    assertFalse(lifeCycleEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty3() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setServer(null);
    lifeCycleEventFilter.setErrorStr(null);
    lifeCycleEventFilter.setEvent(null);
    lifeCycleEventFilter.setStatus("foo");

    // Act and Assert
    assertTrue(lifeCycleEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty4() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setServer(null);
    lifeCycleEventFilter.setErrorStr(null);
    lifeCycleEventFilter.setEvent("foo");
    lifeCycleEventFilter.setStatus(null);

    // Act and Assert
    assertTrue(lifeCycleEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty5() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setServer(null);
    lifeCycleEventFilter.setErrorStr("foo");
    lifeCycleEventFilter.setEvent(null);
    lifeCycleEventFilter.setStatus(null);

    // Act and Assert
    assertTrue(lifeCycleEventFilter.isNotEmpty());
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#isNotEmpty()}
   */
  @Test
  void testIsNotEmpty6() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setServer("Server");

    // Act and Assert
    assertTrue(lifeCycleEventFilter.isNotEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LifeCycleEventFilter#equals(Object)}
   *   <li>{@link LifeCycleEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr(null);
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr(null);
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
    int expectedHashCodeResult = lifeCycleEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, lifeCycleEventFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LifeCycleEventFilter#equals(Object)}
   *   <li>{@link LifeCycleEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent(null);
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent(null);
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
    int expectedHashCodeResult = lifeCycleEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, lifeCycleEventFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LifeCycleEventFilter#equals(Object)}
   *   <li>{@link LifeCycleEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer(null);
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer(null);
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
    int expectedHashCodeResult = lifeCycleEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, lifeCycleEventFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LifeCycleEventFilter#equals(Object)}
   *   <li>{@link LifeCycleEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus(null);

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus(null);

    // Act and Assert
    assertEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
    int expectedHashCodeResult = lifeCycleEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, lifeCycleEventFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LifeCycleEventFilter#equals(Object)}
   *   <li>{@link LifeCycleEventFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    // Act and Assert
    assertEquals(lifeCycleEventFilter, lifeCycleEventFilter);
    int expectedHashCodeResult = lifeCycleEventFilter.hashCode();
    assertEquals(expectedHashCodeResult, lifeCycleEventFilter.hashCode());
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("Server");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr(null);
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Server");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent(null);
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Event");
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer(null);
    lifeCycleEventFilter.setStatus("Status");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Server");

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus(null);

    LifeCycleEventFilter lifeCycleEventFilter2 = new LifeCycleEventFilter();
    lifeCycleEventFilter2.setErrorStr("An error occurred");
    lifeCycleEventFilter2.setEvent("Event");
    lifeCycleEventFilter2.setServer("Server");
    lifeCycleEventFilter2.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, lifeCycleEventFilter2);
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, null);
  }

  /**
   * Method under test: {@link LifeCycleEventFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LifeCycleEventFilter lifeCycleEventFilter = new LifeCycleEventFilter();
    lifeCycleEventFilter.setErrorStr("An error occurred");
    lifeCycleEventFilter.setEvent("Event");
    lifeCycleEventFilter.setServer("Server");
    lifeCycleEventFilter.setStatus("Status");

    // Act and Assert
    assertNotEquals(lifeCycleEventFilter, "Different type to LifeCycleEventFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link LifeCycleEventFilter}
   *   <li>{@link LifeCycleEventFilter#setErrorStr(String)}
   *   <li>{@link LifeCycleEventFilter#setEvent(String)}
   *   <li>{@link LifeCycleEventFilter#setServer(String)}
   *   <li>{@link LifeCycleEventFilter#setStatus(String)}
   *   <li>{@link LifeCycleEventFilter#toString()}
   *   <li>{@link LifeCycleEventFilter#getErrorStr()}
   *   <li>{@link LifeCycleEventFilter#getEvent()}
   *   <li>{@link LifeCycleEventFilter#getEventType()}
   *   <li>{@link LifeCycleEventFilter#getServer()}
   *   <li>{@link LifeCycleEventFilter#getStatus()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    LifeCycleEventFilter actualLifeCycleEventFilter = new LifeCycleEventFilter();
    actualLifeCycleEventFilter.setErrorStr("An error occurred");
    actualLifeCycleEventFilter.setEvent("Event");
    actualLifeCycleEventFilter.setServer("Server");
    actualLifeCycleEventFilter.setStatus("Status");
    String actualToStringResult = actualLifeCycleEventFilter.toString();
    String actualErrorStr = actualLifeCycleEventFilter.getErrorStr();
    String actualEvent = actualLifeCycleEventFilter.getEvent();
    EventType actualEventType = actualLifeCycleEventFilter.getEventType();
    String actualServer = actualLifeCycleEventFilter.getServer();

    // Assert that nothing has changed
    assertEquals("An error occurred", actualErrorStr);
    assertEquals("Event", actualEvent);
    assertEquals("LifeCycleEventFilter(server=Server, event=Event, status=Status, errorStr=An error occurred)",
        actualToStringResult);
    assertEquals("Server", actualServer);
    assertEquals("Status", actualLifeCycleEventFilter.getStatus());
    assertEquals(EventType.LC_EVENT, actualEventType);
  }
}
