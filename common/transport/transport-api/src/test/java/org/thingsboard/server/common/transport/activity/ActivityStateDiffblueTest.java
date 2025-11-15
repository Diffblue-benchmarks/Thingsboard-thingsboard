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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ActivityStateDiffblueTest {
  /**
   * Test {@link ActivityState#equals(Object)}, and {@link ActivityState#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ActivityState#equals(Object)}
   *   <li>{@link ActivityState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActivityState.equals(Object)", "int ActivityState.hashCode()"})
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
   * Test {@link ActivityState#equals(Object)}, and {@link ActivityState#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ActivityState#equals(Object)}
   *   <li>{@link ActivityState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActivityState.equals(Object)", "int ActivityState.hashCode()"})
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
   * Test {@link ActivityState#equals(Object)}, and {@link ActivityState#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ActivityState#equals(Object)}
   *   <li>{@link ActivityState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActivityState.equals(Object)", "int ActivityState.hashCode()"})
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
   * Test {@link ActivityState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActivityState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActivityState.equals(Object)", "int ActivityState.hashCode()"})
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
   * Test {@link ActivityState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActivityState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActivityState.equals(Object)", "int ActivityState.hashCode()"})
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
   * Test {@link ActivityState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActivityState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActivityState.equals(Object)", "int ActivityState.hashCode()"})
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
   * Test {@link ActivityState#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActivityState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActivityState.equals(Object)", "int ActivityState.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ActivityState<Object> activityState = new ActivityState<>();
    activityState.setLastRecordedTime(1L);
    activityState.setMetadata("Metadata");

    // Act and Assert
    assertNotEquals(activityState, null);
  }

  /**
   * Test {@link ActivityState#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ActivityState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ActivityState.equals(Object)", "int ActivityState.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ActivityState<Object> activityState = new ActivityState<>();
    activityState.setLastRecordedTime(1L);
    activityState.setMetadata("Metadata");

    // Act and Assert
    assertNotEquals(activityState, "Different type to ActivityState");
  }

  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ActivityState.<init>()", "long ActivityState.getLastRecordedTime()",
      "Object ActivityState.getMetadata()", "void ActivityState.setLastRecordedTime(long)",
      "void ActivityState.setMetadata(Object)", "String ActivityState.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ActivityState<Object> actualActivityState = new ActivityState<>();
    actualActivityState.setLastRecordedTime(1L);
    actualActivityState.setMetadata("Metadata");
    String actualToStringResult = actualActivityState.toString();
    long actualLastRecordedTime = actualActivityState.getLastRecordedTime();

    // Assert
    assertEquals("ActivityState(lastRecordedTime=1, metadata=Metadata)", actualToStringResult);
    assertEquals("Metadata", actualActivityState.getMetadata());
    assertEquals(1L, actualLastRecordedTime);
  }
}
