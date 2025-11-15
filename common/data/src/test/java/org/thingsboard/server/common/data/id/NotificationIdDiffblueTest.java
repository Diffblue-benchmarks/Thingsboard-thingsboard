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
package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class NotificationIdDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationId#NotificationId(UUID)}
   *   <li>{@link NotificationId#getEntityType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act
    NotificationId actualNotificationId = new NotificationId(id);
    EntityType actualEntityType = actualNotificationId.getEntityType();

    // Assert
    UUID id2 = actualNotificationId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertEquals(EntityType.NOTIFICATION, actualEntityType);
    assertSame(id, id2);
  }
}
