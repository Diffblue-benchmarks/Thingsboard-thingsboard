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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class UUIDConverterDiffblueTest {
  /**
   * Method under test: {@link UUIDConverter#fromTimeUUID(UUID)}
   */
  @Test
  void testFromTimeUUID() {
    // Arrange, Act and Assert
    assertEquals("1b21dd2138140008080808080808080", UUIDConverter.fromTimeUUID(EntityId.NULL_UUID));
    assertThrows(IllegalArgumentException.class, () -> UUIDConverter.fromTimeUUID(UUID.randomUUID()));
  }

  /**
   * Method under test: {@link UUIDConverter#fromTimeUUIDs(List)}
   */
  @Test
  void testFromTimeUUIDs() {
    // Arrange and Act
    List<String> actualFromTimeUUIDsResult = UUIDConverter.fromTimeUUIDs(new ArrayList<>());

    // Assert
    assertTrue(actualFromTimeUUIDsResult.isEmpty());
  }

  /**
   * Method under test: {@link UUIDConverter#fromTimeUUIDs(List)}
   */
  @Test
  void testFromTimeUUIDs2() {
    // Arrange and Act
    List<String> actualFromTimeUUIDsResult = UUIDConverter.fromTimeUUIDs(null);

    // Assert
    assertNull(actualFromTimeUUIDsResult);
  }

  /**
   * Method under test: {@link UUIDConverter#fromTimeUUIDs(List)}
   */
  @Test
  void testFromTimeUUIDs3() {
    // Arrange
    ArrayList<UUID> uuids = new ArrayList<>();
    uuids.add(EntityId.NULL_UUID);

    // Act
    List<String> actualFromTimeUUIDsResult = UUIDConverter.fromTimeUUIDs(uuids);

    // Assert
    assertEquals(1, actualFromTimeUUIDsResult.size());
    assertEquals("1b21dd2138140008080808080808080", actualFromTimeUUIDsResult.get(0));
  }

  /**
   * Method under test: {@link UUIDConverter#fromTimeUUIDs(List)}
   */
  @Test
  void testFromTimeUUIDs4() {
    // Arrange
    ArrayList<UUID> uuids = new ArrayList<>();
    uuids.add(EntityId.NULL_UUID);
    uuids.add(EntityId.NULL_UUID);

    // Act
    List<String> actualFromTimeUUIDsResult = UUIDConverter.fromTimeUUIDs(uuids);

    // Assert
    assertEquals(2, actualFromTimeUUIDsResult.size());
    assertEquals("1b21dd2138140008080808080808080", actualFromTimeUUIDsResult.get(0));
    assertEquals("1b21dd2138140008080808080808080", actualFromTimeUUIDsResult.get(1));
  }

  /**
   * Method under test: {@link UUIDConverter#fromTimeUUIDs(List)}
   */
  @Test
  void testFromTimeUUIDs5() {
    // Arrange
    ArrayList<UUID> uuids = new ArrayList<>();
    uuids.add(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> UUIDConverter.fromTimeUUIDs(uuids));
  }
}
