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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.UserId;

class UserEmailInfoDiffblueTest {
  /**
   * Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UserEmailInfo userEmailInfo = new UserEmailInfo(mock(UserId.class), "jane.doe@example.org", "Jane", "Doe");

    // Act and Assert
    assertNotEquals(userEmailInfo, new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe"));
  }

  /**
   * Method under test: {@link UserEmailInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new UserEmailInfo(mock(UserId.class), "jane.doe@example.org", "Jane", "Doe"), "42");
  }

  /**
   * Method under test: {@link UserEmailInfo#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new UserEmailInfo(null, "jane.doe@example.org", "Jane", "Doe")).getId());
  }
}
