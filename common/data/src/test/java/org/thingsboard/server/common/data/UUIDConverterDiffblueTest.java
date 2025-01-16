package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class UUIDConverterDiffblueTest {
  /**
   * Test {@link UUIDConverter#fromTimeUUID(UUID)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDConverter#fromTimeUUID(UUID)}
   */
  @Test
  @DisplayName("Test fromTimeUUID(UUID); then throw IllegalArgumentException")
  void testFromTimeUUID_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> UUIDConverter.fromTimeUUID(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

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
  void testFromTimeUUID_whenNull_uuid_thenReturn1b21dd2138140008080808080808080() {
    // Arrange, Act and Assert
    assertEquals("1b21dd2138140008080808080808080", UUIDConverter.fromTimeUUID(EntityId.NULL_UUID));
  }

  /**
   * Test {@link UUIDConverter#fromTimeUUIDs(List)}.
   * <ul>
   *   <li>Given {@link EntityId#NULL_UUID}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link EntityId#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDConverter#fromTimeUUIDs(List)}
   */
  @Test
  @DisplayName("Test fromTimeUUIDs(List); given NULL_UUID; when ArrayList() add NULL_UUID")
  void testFromTimeUUIDs_givenNull_uuid_whenArrayListAddNull_uuid() {
    // Arrange
    ArrayList<UUID> uuids = new ArrayList<>();
    uuids.add(EntityId.NULL_UUID);
    uuids.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> UUIDConverter.fromTimeUUIDs(uuids));
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
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDConverter#fromTimeUUIDs(List)}
   */
  @Test
  @DisplayName("Test fromTimeUUIDs(List); then throw IllegalArgumentException")
  void testFromTimeUUIDs_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<UUID> uuids = new ArrayList<>();
    uuids.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> UUIDConverter.fromTimeUUIDs(uuids));
  }

  /**
   * Test {@link UUIDConverter#fromTimeUUIDs(List)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link UUIDConverter#fromTimeUUIDs(List)}
   */
  @Test
  @DisplayName("Test fromTimeUUIDs(List); then throw IllegalArgumentException")
  void testFromTimeUUIDs_thenThrowIllegalArgumentException2() {
    // Arrange
    ArrayList<UUID> uuids = new ArrayList<>();
    uuids.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    uuids.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  void testFromTimeUUIDs_whenNull_thenReturnNull() {
    // Arrange and Act
    List<String> actualFromTimeUUIDsResult = UUIDConverter.fromTimeUUIDs(null);

    // Assert
    assertNull(actualFromTimeUUIDsResult);
  }
}
