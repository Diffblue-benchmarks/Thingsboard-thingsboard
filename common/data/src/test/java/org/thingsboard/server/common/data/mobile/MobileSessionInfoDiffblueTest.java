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
package org.thingsboard.server.common.data.mobile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

class MobileSessionInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MobileSessionInfo#equals(Object)}
   *   <li>{@link MobileSessionInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileSessionInfo mobileSessionInfo = new MobileSessionInfo();
    mobileSessionInfo.setFcmTokenTimestamp(1L);

    MobileSessionInfo mobileSessionInfo2 = new MobileSessionInfo();
    mobileSessionInfo2.setFcmTokenTimestamp(1L);

    // Act and Assert
    assertEquals(mobileSessionInfo, mobileSessionInfo2);
    int expectedHashCodeResult = mobileSessionInfo.hashCode();
    assertEquals(expectedHashCodeResult, mobileSessionInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MobileSessionInfo#equals(Object)}
   *   <li>{@link MobileSessionInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileSessionInfo mobileSessionInfo = new MobileSessionInfo();
    mobileSessionInfo.setFcmTokenTimestamp(1L);

    // Act and Assert
    assertEquals(mobileSessionInfo, mobileSessionInfo);
    int expectedHashCodeResult = mobileSessionInfo.hashCode();
    assertEquals(expectedHashCodeResult, mobileSessionInfo.hashCode());
  }

  /**
   * Method under test: {@link MobileSessionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileSessionInfo mobileSessionInfo = new MobileSessionInfo();
    mobileSessionInfo.setFcmTokenTimestamp(3L);

    MobileSessionInfo mobileSessionInfo2 = new MobileSessionInfo();
    mobileSessionInfo2.setFcmTokenTimestamp(1L);

    // Act and Assert
    assertNotEquals(mobileSessionInfo, mobileSessionInfo2);
  }

  /**
   * Method under test: {@link MobileSessionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    MobileSessionInfo mobileSessionInfo = new MobileSessionInfo();
    mobileSessionInfo.setFcmTokenTimestamp(1L);

    // Act and Assert
    assertNotEquals(mobileSessionInfo, null);
  }

  /**
   * Method under test: {@link MobileSessionInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    MobileSessionInfo mobileSessionInfo = new MobileSessionInfo();
    mobileSessionInfo.setFcmTokenTimestamp(1L);

    // Act and Assert
    assertNotEquals(mobileSessionInfo, "Different type to MobileSessionInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link MobileSessionInfo}
   *   <li>{@link MobileSessionInfo#setFcmTokenTimestamp(long)}
   *   <li>{@link MobileSessionInfo#toString()}
   *   <li>{@link MobileSessionInfo#getFcmTokenTimestamp()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    MobileSessionInfo actualMobileSessionInfo = new MobileSessionInfo();
    actualMobileSessionInfo.setFcmTokenTimestamp(1L);
    String actualToStringResult = actualMobileSessionInfo.toString();

    // Assert that nothing has changed
    assertEquals("MobileSessionInfo(fcmTokenTimestamp=1)", actualToStringResult);
    assertEquals(1L, actualMobileSessionInfo.getFcmTokenTimestamp());
  }
}
