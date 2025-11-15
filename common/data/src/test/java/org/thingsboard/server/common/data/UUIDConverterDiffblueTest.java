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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class UUIDConverterDiffblueTest {
  /**
   * Test {@link UUIDConverter#fromTimeUUID(UUID)}.
   * <ul>
   *   <li>When {@link EntityId#NULL_UUID}.</li>
   *   <li>Then return {@code 1b21dd2138140008080808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDConverter#fromTimeUUID(UUID)}
   */
  @Test
  @DisplayName("Test fromTimeUUID(UUID); when NULL_UUID; then return '1b21dd2138140008080808080808080'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String UUIDConverter.fromTimeUUID(UUID)"})
  void testFromTimeUUID_whenNull_uuid_thenReturn1b21dd2138140008080808080808080() {
    // Arrange, Act and Assert
    assertEquals("1b21dd2138140008080808080808080", UUIDConverter.fromTimeUUID(EntityId.NULL_UUID));
  }

  /**
   * Test {@link UUIDConverter#fromTimeUUID(UUID)}.
   * <ul>
   *   <li>When randomUUID.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDConverter#fromTimeUUID(UUID)}
   */
  @Test
  @DisplayName("Test fromTimeUUID(UUID); when randomUUID; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String UUIDConverter.fromTimeUUID(UUID)"})
  void testFromTimeUUID_whenRandomUUID_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> UUIDConverter.fromTimeUUID(UUID.randomUUID()));
  }

  /**
   * Test {@link UUIDConverter#fromTimeUUIDs(List)}.
   * <ul>
   *   <li>Given {@link EntityId#NULL_UUID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link EntityId#NULL_UUID}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDConverter#fromTimeUUIDs(List)}
   */
  @Test
  @DisplayName("Test fromTimeUUIDs(List); given NULL_UUID; when ArrayList() add NULL_UUID; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UUIDConverter.fromTimeUUIDs(List)"})
  void testFromTimeUUIDs_givenNull_uuid_whenArrayListAddNull_uuid_thenReturnSizeIsOne() {
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
   * Test {@link UUIDConverter#fromTimeUUIDs(List)}.
   * <ul>
   *   <li>Given {@link EntityId#NULL_UUID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link EntityId#NULL_UUID}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDConverter#fromTimeUUIDs(List)}
   */
  @Test
  @DisplayName("Test fromTimeUUIDs(List); given NULL_UUID; when ArrayList() add NULL_UUID; then return size is two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UUIDConverter.fromTimeUUIDs(List)"})
  void testFromTimeUUIDs_givenNull_uuid_whenArrayListAddNull_uuid_thenReturnSizeIsTwo() {
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
   * Test {@link UUIDConverter#fromTimeUUIDs(List)}.
   * <ul>
   *   <li>Given randomUUID.</li>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDConverter#fromTimeUUIDs(List)}
   */
  @Test
  @DisplayName("Test fromTimeUUIDs(List); given randomUUID; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UUIDConverter.fromTimeUUIDs(List)"})
  void testFromTimeUUIDs_givenRandomUUID_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<UUID> uuids = new ArrayList<>();
    uuids.add(UUID.randomUUID());

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> UUIDConverter.fromTimeUUIDs(uuids));
  }

  /**
   * Test {@link UUIDConverter#fromTimeUUIDs(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDConverter#fromTimeUUIDs(List)}
   */
  @Test
  @DisplayName("Test fromTimeUUIDs(List); when ArrayList(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UUIDConverter.fromTimeUUIDs(List)"})
  void testFromTimeUUIDs_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<String> actualFromTimeUUIDsResult = UUIDConverter.fromTimeUUIDs(new ArrayList<>());

    // Assert
    assertTrue(actualFromTimeUUIDsResult.isEmpty());
  }

  /**
   * Test {@link UUIDConverter#fromTimeUUIDs(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDConverter#fromTimeUUIDs(List)}
   */
  @Test
  @DisplayName("Test fromTimeUUIDs(List); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List UUIDConverter.fromTimeUUIDs(List)"})
  void testFromTimeUUIDs_whenNull_thenReturnNull() {
    // Arrange and Act
    List<String> actualFromTimeUUIDsResult = UUIDConverter.fromTimeUUIDs(null);

    // Assert
    assertNull(actualFromTimeUUIDsResult);
  }
}
