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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class EdgeIdDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeId#EdgeId(UUID)}
   *   <li>{@link EdgeId#getEntityType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeId.<init>(UUID)", "EntityType EdgeId.getEntityType()"})
  void testGettersAndSetters() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act
    EdgeId actualEdgeId = new EdgeId(id);
    EntityType actualEntityType = actualEdgeId.getEntityType();

    // Assert
    UUID id2 = actualEdgeId.getId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", id2.toString());
    assertEquals(EntityType.EDGE, actualEntityType);
    assertSame(id, id2);
  }

  /**
   * Test {@link EdgeId#fromUUID(UUID)}.
   * <p>
   * Method under test: {@link EdgeId#fromUUID(UUID)}
   */
  @Test
  @DisplayName("Test fromUUID(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EdgeId EdgeId.fromUUID(UUID)"})
  void testFromUUID() {
    // Arrange
    UUID id = EntityId.NULL_UUID;

    // Act
    EdgeId actualFromUUIDResult = EdgeId.fromUUID(id);

    // Assert
    assertEquals(EntityType.EDGE, actualFromUUIDResult.getEntityType());
    assertTrue(actualFromUUIDResult.isNullUid());
    assertSame(id, actualFromUUIDResult.getId());
  }
}
