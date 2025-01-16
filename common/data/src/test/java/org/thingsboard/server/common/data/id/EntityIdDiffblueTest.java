package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EntityIdDiffblueTest {
  /**
   * Test {@link EntityId#isNullUid()}.
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is
   * {@link EntityId#NULL_UUID}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityId#isNullUid()}
   */
  @Test
  @DisplayName("Test isNullUid(); given AlarmId(UUID) with id is NULL_UUID; then return 'true'")
  void testIsNullUid_givenAlarmIdWithIdIsNull_uuid_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new AlarmId(EntityId.NULL_UUID)).isNullUid());
  }

  /**
   * Test {@link EntityId#isNullUid()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityId#isNullUid()}
   */
  @Test
  @DisplayName("Test isNullUid(); then return 'false'")
  void testIsNullUid_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))).isNullUid());
  }
}
