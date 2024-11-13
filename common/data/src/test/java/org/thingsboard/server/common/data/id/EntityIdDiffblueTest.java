package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EntityIdDiffblueTest {
  /**
   * Test {@link EntityId#isNullUid()}.
   * <p>
   * Method under test: {@link EntityId#isNullUid()}
   */
  @Test
  @DisplayName("Test isNullUid()")
  void testIsNullUid() {
    // Arrange
    AlarmId alarmId = new AlarmId(EntityId.NULL_UUID);

    // Act
    boolean actualIsNullUidResult = alarmId.isNullUid();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", alarmId.getId().toString());
    assertTrue(actualIsNullUidResult);
  }

  /**
   * Test {@link EntityId#isNullUid()}.
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityId#isNullUid()}
   */
  @Test
  @DisplayName("Test isNullUid(); given AlarmId(UUID) with id is randomUUID; then return 'false'")
  void testIsNullUid_givenAlarmIdWithIdIsRandomUUID_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new AlarmId(UUID.randomUUID())).isNullUid());
  }
}
