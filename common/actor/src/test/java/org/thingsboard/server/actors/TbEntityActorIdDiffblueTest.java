package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.AlarmId;

class TbEntityActorIdDiffblueTest {
  /**
   * Test {@link TbEntityActorId#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityActorId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbEntityActorId tbEntityActorId = new TbEntityActorId(mock(AlarmId.class));

    // Act and Assert
    assertNotEquals(tbEntityActorId, new TbEntityActorId(null));
  }

  /**
   * Test {@link TbEntityActorId#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityActorId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TbEntityActorId(mock(AlarmId.class)), "42");
  }

  /**
   * Test {@link TbEntityActorId#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityActorId#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new TbEntityActorId(mock(AlarmId.class)), null);
  }

  /**
   * Test {@link TbEntityActorId#getEntityType()}.
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   *   <li>Then return {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbEntityActorId#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType(); given AlarmId(UUID) with id is randomUUID; then return 'ALARM'")
  void testGetEntityType_givenAlarmIdWithIdIsRandomUUID_thenReturnAlarm() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ALARM, (new TbEntityActorId(new AlarmId(UUID.randomUUID()))).getEntityType());
  }
}
