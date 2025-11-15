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
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;

class MobileAppOauth2ClientDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppOauth2Client#equals(Object)}
   *   <li>{@link MobileAppOauth2Client#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();
    MobileAppOauth2Client mobileAppOauth2Client2 = new MobileAppOauth2Client();

    // Act and Assert
    assertEquals(mobileAppOauth2Client, mobileAppOauth2Client2);
    int expectedHashCodeResult = mobileAppOauth2Client.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2Client2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppOauth2Client#equals(Object)}
   *   <li>{@link MobileAppOauth2Client#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();

    // Act and Assert
    assertEquals(mobileAppOauth2Client, mobileAppOauth2Client);
    int expectedHashCodeResult = mobileAppOauth2Client.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2Client.hashCode());
  }

  /**
   * Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppOauth2Client(), 1);
  }

  /**
   * Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client(mock(MobileAppId.class), null);

    // Act and Assert
    assertNotEquals(mobileAppOauth2Client, new MobileAppOauth2Client());
  }

  /**
   * Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();
    mobileAppOauth2Client.setOAuth2ClientId(new OAuth2ClientId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(mobileAppOauth2Client, new MobileAppOauth2Client());
  }

  /**
   * Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();

    MobileAppOauth2Client mobileAppOauth2Client2 = new MobileAppOauth2Client();
    mobileAppOauth2Client2.setMobileAppId(new MobileAppId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(mobileAppOauth2Client, mobileAppOauth2Client2);
  }

  /**
   * Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    MobileAppOauth2Client mobileAppOauth2Client = new MobileAppOauth2Client();

    MobileAppOauth2Client mobileAppOauth2Client2 = new MobileAppOauth2Client();
    mobileAppOauth2Client2.setOAuth2ClientId(new OAuth2ClientId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(mobileAppOauth2Client, mobileAppOauth2Client2);
  }

  /**
   * Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppOauth2Client(), null);
  }

  /**
   * Method under test: {@link MobileAppOauth2Client#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppOauth2Client(), "Different type to MobileAppOauth2Client");
  }
}
