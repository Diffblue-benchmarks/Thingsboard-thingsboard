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
package org.thingsboard.server.common.data.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;

class DomainOauth2ClientDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DomainOauth2Client#equals(Object)}
   *   <li>{@link DomainOauth2Client#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();
    DomainOauth2Client domainOauth2Client2 = new DomainOauth2Client();

    // Act and Assert
    assertEquals(domainOauth2Client, domainOauth2Client2);
    int expectedHashCodeResult = domainOauth2Client.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2Client2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link DomainOauth2Client#equals(Object)}
   *   <li>{@link DomainOauth2Client#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();

    // Act and Assert
    assertEquals(domainOauth2Client, domainOauth2Client);
    int expectedHashCodeResult = domainOauth2Client.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2Client.hashCode());
  }

  /**
   * Method under test: {@link DomainOauth2Client#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DomainOauth2Client(), 1);
  }

  /**
   * Method under test: {@link DomainOauth2Client#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client(mock(DomainId.class), null);

    // Act and Assert
    assertNotEquals(domainOauth2Client, new DomainOauth2Client());
  }

  /**
   * Method under test: {@link DomainOauth2Client#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();
    domainOauth2Client.setOAuth2ClientId(new OAuth2ClientId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(domainOauth2Client, new DomainOauth2Client());
  }

  /**
   * Method under test: {@link DomainOauth2Client#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();

    DomainOauth2Client domainOauth2Client2 = new DomainOauth2Client();
    domainOauth2Client2.setDomainId(new DomainId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(domainOauth2Client, domainOauth2Client2);
  }

  /**
   * Method under test: {@link DomainOauth2Client#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();

    DomainOauth2Client domainOauth2Client2 = new DomainOauth2Client();
    domainOauth2Client2.setOAuth2ClientId(new OAuth2ClientId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(domainOauth2Client, domainOauth2Client2);
  }

  /**
   * Method under test: {@link DomainOauth2Client#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DomainOauth2Client(), null);
  }

  /**
   * Method under test: {@link DomainOauth2Client#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DomainOauth2Client(), "Different type to DomainOauth2Client");
  }
}
