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
package org.thingsboard.server.common.data.security.event;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.UserId;

class UserCredentialsInvalidationEventDiffblueTest {
  /**
   * Method under test: {@link UserCredentialsInvalidationEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserCredentialsInvalidationEvent userCredentialsInvalidationEvent = new UserCredentialsInvalidationEvent(
        mock(UserId.class));

    // Act and Assert
    assertNotEquals(userCredentialsInvalidationEvent, new UserCredentialsInvalidationEvent(null));
  }

  /**
   * Method under test: {@link UserCredentialsInvalidationEvent#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080",
        (new UserCredentialsInvalidationEvent(new UserId(EntityId.NULL_UUID))).getId());
  }

  /**
   * Method under test: {@link UserCredentialsInvalidationEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new UserCredentialsInvalidationEvent(mock(UserId.class)), "42");
  }
}
