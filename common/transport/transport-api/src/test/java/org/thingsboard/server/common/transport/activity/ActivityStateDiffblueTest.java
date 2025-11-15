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
package org.thingsboard.server.common.transport.activity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class ActivityStateDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ActivityState#equals(Object)}
   *   <li>{@link ActivityState#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ActivityState<Object> activityState = new ActivityState<>();
    activityState.setLastRecordedTime(1L);
    activityState.setMetadata("Metadata");

    ActivityState<Object> activityState2 = new ActivityState<>();
    activityState2.setLastRecordedTime(1L);
    activityState2.setMetadata("Metadata");

    // Act and Assert
    assertEquals(activityState, activityState2);
    int expectedHashCodeResult = activityState.hashCode();
    assertEquals(expectedHashCodeResult, activityState2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ActivityState#equals(Object)}
   *   <li>{@link ActivityState#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ActivityState<Object> activityState = new ActivityState<>();
    activityState.setLastRecordedTime(1L);
    activityState.setMetadata(null);

    ActivityState<Object> activityState2 = new ActivityState<>();
    activityState2.setLastRecordedTime(1L);
    activityState2.setMetadata(null);

    // Act and Assert
    assertEquals(activityState, activityState2);
    int expectedHashCodeResult = activityState.hashCode();
    assertEquals(expectedHashCodeResult, activityState2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ActivityState#equals(Object)}
   *   <li>{@link ActivityState#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ActivityState<Object> activityState = new ActivityState<>();
    activityState.setLastRecordedTime(1L);
    activityState.setMetadata("Metadata");

    // Act and Assert
    assertEquals(activityState, activityState);
    int expectedHashCodeResult = activityState.hashCode();
    assertEquals(expectedHashCodeResult, activityState.hashCode());
  }

  /**
   * Method under test: {@link ActivityState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ActivityState<Object> activityState = new ActivityState<>();
    activityState.setLastRecordedTime(3L);
    activityState.setMetadata("Metadata");

    ActivityState<Object> activityState2 = new ActivityState<>();
    activityState2.setLastRecordedTime(1L);
    activityState2.setMetadata("Metadata");

    // Act and Assert
    assertNotEquals(activityState, activityState2);
  }

  /**
   * Method under test: {@link ActivityState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ActivityState<Object> activityState = new ActivityState<>();
    activityState.setLastRecordedTime(1L);
    activityState.setMetadata("Metadata");

    ActivityState<Object> activityState2 = new ActivityState<>();
    activityState2.setLastRecordedTime(1L);
    activityState2.setMetadata(activityState);

    ActivityState<Object> activityState3 = new ActivityState<>();
    activityState3.setLastRecordedTime(1L);
    activityState3.setMetadata("Metadata");

    // Act and Assert
    assertNotEquals(activityState2, activityState3);
  }

  /**
   * Method under test: {@link ActivityState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ActivityState<Object> activityState = new ActivityState<>();
    activityState.setLastRecordedTime(1L);
    activityState.setMetadata(null);

    ActivityState<Object> activityState2 = new ActivityState<>();
    activityState2.setLastRecordedTime(1L);
    activityState2.setMetadata("Metadata");

    // Act and Assert
    assertNotEquals(activityState, activityState2);
  }

  /**
   * Method under test: {@link ActivityState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ActivityState<Object> activityState = new ActivityState<>();
    activityState.setLastRecordedTime(1L);
    activityState.setMetadata("Metadata");

    // Act and Assert
    assertNotEquals(activityState, null);
  }

  /**
   * Method under test: {@link ActivityState#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ActivityState<Object> activityState = new ActivityState<>();
    activityState.setLastRecordedTime(1L);
    activityState.setMetadata("Metadata");

    // Act and Assert
    assertNotEquals(activityState, "Different type to ActivityState");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ActivityState}
   *   <li>{@link ActivityState#setLastRecordedTime(long)}
   *   <li>{@link ActivityState#setMetadata(Object)}
   *   <li>{@link ActivityState#toString()}
   *   <li>{@link ActivityState#getLastRecordedTime()}
   *   <li>{@link ActivityState#getMetadata()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ActivityState<Object> actualActivityState = new ActivityState<>();
    actualActivityState.setLastRecordedTime(1L);
    actualActivityState.setMetadata("Metadata");
    String actualToStringResult = actualActivityState.toString();
    long actualLastRecordedTime = actualActivityState.getLastRecordedTime();

    // Assert that nothing has changed
    assertEquals("ActivityState(lastRecordedTime=1, metadata=Metadata)", actualToStringResult);
    assertEquals("Metadata", actualActivityState.getMetadata());
    assertEquals(1L, actualLastRecordedTime);
  }
}
