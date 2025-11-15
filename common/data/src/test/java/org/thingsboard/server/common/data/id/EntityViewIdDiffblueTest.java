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

class EntityViewIdDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewId#EntityViewId(UUID)}
   *   <li>{@link EntityViewId#getEntityType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act
    EntityViewId actualEntityViewId = new EntityViewId(id);
    EntityType actualEntityType = actualEntityViewId.getEntityType();

    // Assert
    UUID id2 = actualEntityViewId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertEquals(EntityType.ENTITY_VIEW, actualEntityType);
    assertSame(id, id2);
  }
}
