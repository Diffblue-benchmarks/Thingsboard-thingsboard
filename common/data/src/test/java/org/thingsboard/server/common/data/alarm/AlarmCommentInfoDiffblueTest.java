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
package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class AlarmCommentInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentInfo#equals(Object)}
   *   <li>{@link AlarmCommentInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    AlarmCommentInfo alarmCommentInfo2 = new AlarmCommentInfo();

    // Act and Assert
    assertEquals(alarmCommentInfo, alarmCommentInfo2);
    int expectedHashCodeResult = alarmCommentInfo.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentInfo#equals(Object)}
   *   <li>{@link AlarmCommentInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    alarmCommentInfo.setFirstName("Jane");

    AlarmCommentInfo alarmCommentInfo2 = new AlarmCommentInfo();
    alarmCommentInfo2.setFirstName("Jane");

    // Act and Assert
    assertEquals(alarmCommentInfo, alarmCommentInfo2);
    int expectedHashCodeResult = alarmCommentInfo.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentInfo#equals(Object)}
   *   <li>{@link AlarmCommentInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    alarmCommentInfo.setLastName("Doe");

    AlarmCommentInfo alarmCommentInfo2 = new AlarmCommentInfo();
    alarmCommentInfo2.setLastName("Doe");

    // Act and Assert
    assertEquals(alarmCommentInfo, alarmCommentInfo2);
    int expectedHashCodeResult = alarmCommentInfo.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentInfo#equals(Object)}
   *   <li>{@link AlarmCommentInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    alarmCommentInfo.setEmail("jane.doe@example.org");

    AlarmCommentInfo alarmCommentInfo2 = new AlarmCommentInfo();
    alarmCommentInfo2.setEmail("jane.doe@example.org");

    // Act and Assert
    assertEquals(alarmCommentInfo, alarmCommentInfo2);
    int expectedHashCodeResult = alarmCommentInfo.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentInfo#equals(Object)}
   *   <li>{@link AlarmCommentInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();

    // Act and Assert
    assertEquals(alarmCommentInfo, alarmCommentInfo);
    int expectedHashCodeResult = alarmCommentInfo.hashCode();
    assertEquals(expectedHashCodeResult, alarmCommentInfo.hashCode());
  }

  /**
   * Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentInfo(), 1);
    assertNotEquals(new AlarmCommentInfo(), mock(AlarmComment.class));
  }

  /**
   * Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    alarmCommentInfo.setFirstName("Jane");

    // Act and Assert
    assertNotEquals(alarmCommentInfo, new AlarmCommentInfo());
  }

  /**
   * Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    alarmCommentInfo.setLastName("Doe");

    // Act and Assert
    assertNotEquals(alarmCommentInfo, new AlarmCommentInfo());
  }

  /**
   * Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    alarmCommentInfo.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(alarmCommentInfo, new AlarmCommentInfo());
  }

  /**
   * Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();
    alarmCommentInfo.setType(AlarmCommentType.SYSTEM);

    // Act and Assert
    assertNotEquals(alarmCommentInfo, new AlarmCommentInfo());
  }

  /**
   * Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();

    AlarmCommentInfo alarmCommentInfo2 = new AlarmCommentInfo();
    alarmCommentInfo2.setFirstName("Jane");

    // Act and Assert
    assertNotEquals(alarmCommentInfo, alarmCommentInfo2);
  }

  /**
   * Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();

    AlarmCommentInfo alarmCommentInfo2 = new AlarmCommentInfo();
    alarmCommentInfo2.setLastName("Doe");

    // Act and Assert
    assertNotEquals(alarmCommentInfo, alarmCommentInfo2);
  }

  /**
   * Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    AlarmCommentInfo alarmCommentInfo = new AlarmCommentInfo();

    AlarmCommentInfo alarmCommentInfo2 = new AlarmCommentInfo();
    alarmCommentInfo2.setEmail("jane.doe@example.org");

    // Act and Assert
    assertNotEquals(alarmCommentInfo, alarmCommentInfo2);
  }

  /**
   * Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentInfo(), null);
  }

  /**
   * Method under test: {@link AlarmCommentInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AlarmCommentInfo(), "Different type to AlarmCommentInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link AlarmCommentInfo#AlarmCommentInfo()}
   *   <li>{@link AlarmCommentInfo#setEmail(String)}
   *   <li>{@link AlarmCommentInfo#setFirstName(String)}
   *   <li>{@link AlarmCommentInfo#setLastName(String)}
   *   <li>{@link AlarmCommentInfo#toString()}
   *   <li>{@link AlarmCommentInfo#getEmail()}
   *   <li>{@link AlarmCommentInfo#getFirstName()}
   *   <li>{@link AlarmCommentInfo#getLastName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    AlarmCommentInfo actualAlarmCommentInfo = new AlarmCommentInfo();
    actualAlarmCommentInfo.setEmail("jane.doe@example.org");
    actualAlarmCommentInfo.setFirstName("Jane");
    actualAlarmCommentInfo.setLastName("Doe");
    String actualToStringResult = actualAlarmCommentInfo.toString();
    String actualEmail = actualAlarmCommentInfo.getEmail();
    String actualFirstName = actualAlarmCommentInfo.getFirstName();

    // Assert that nothing has changed
    assertEquals("AlarmCommentInfo(firstName=Jane, lastName=Doe, email=jane.doe@example.org)", actualToStringResult);
    assertEquals("Doe", actualAlarmCommentInfo.getLastName());
    assertEquals("Jane", actualFirstName);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals(0L, actualAlarmCommentInfo.getCreatedTime());
  }

  /**
   * Method under test: {@link AlarmCommentInfo#AlarmCommentInfo(AlarmComment)}
   */
  @Test
  void testNewAlarmCommentInfo() {
    // Arrange and Act
    AlarmCommentInfo actualAlarmCommentInfo = new AlarmCommentInfo(new AlarmComment());

    // Assert
    assertNull(actualAlarmCommentInfo.getComment());
    assertNull(actualAlarmCommentInfo.getEmail());
    assertNull(actualAlarmCommentInfo.getFirstName());
    assertNull(actualAlarmCommentInfo.getLastName());
    assertNull(actualAlarmCommentInfo.getUuidId());
    assertNull(actualAlarmCommentInfo.getType());
    assertNull(actualAlarmCommentInfo.getId());
    assertNull(actualAlarmCommentInfo.getAlarmId());
    assertNull(actualAlarmCommentInfo.getUserId());
    assertEquals(0L, actualAlarmCommentInfo.getCreatedTime());
  }

  /**
   * Method under test:
   * {@link AlarmCommentInfo#AlarmCommentInfo(AlarmComment, String, String, String)}
   */
  @Test
  void testNewAlarmCommentInfo2() {
    // Arrange and Act
    AlarmCommentInfo actualAlarmCommentInfo = new AlarmCommentInfo(new AlarmComment(), "Jane", "Doe",
        "jane.doe@example.org");

    // Assert
    assertEquals("Doe", actualAlarmCommentInfo.getLastName());
    assertEquals("Jane", actualAlarmCommentInfo.getFirstName());
    assertEquals("jane.doe@example.org", actualAlarmCommentInfo.getEmail());
    assertNull(actualAlarmCommentInfo.getComment());
    assertNull(actualAlarmCommentInfo.getUuidId());
    assertNull(actualAlarmCommentInfo.getType());
    assertNull(actualAlarmCommentInfo.getId());
    assertNull(actualAlarmCommentInfo.getAlarmId());
    assertNull(actualAlarmCommentInfo.getUserId());
    assertEquals(0L, actualAlarmCommentInfo.getCreatedTime());
  }
}
