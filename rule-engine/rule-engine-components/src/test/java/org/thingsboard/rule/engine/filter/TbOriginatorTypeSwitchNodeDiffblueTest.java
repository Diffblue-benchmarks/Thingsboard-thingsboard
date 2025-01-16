package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;

class TbOriginatorTypeSwitchNodeDiffblueTest {
  /**
   * Test {@link TbOriginatorTypeSwitchNode#getRelationType(TbContext, EntityId)}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   *   <li>Then return {@code Alarm}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TbOriginatorTypeSwitchNode#getRelationType(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test getRelationType(TbContext, EntityId); when AlarmId(UUID) with id is randomUUID; then return 'Alarm'")
  void testGetRelationType_whenAlarmIdWithIdIsRandomUUID_thenReturnAlarm() {
    // Arrange
    TbOriginatorTypeSwitchNode tbOriginatorTypeSwitchNode = new TbOriginatorTypeSwitchNode();
    TbContext ctx = mock(TbContext.class);

    // Act and Assert
    assertEquals("Alarm", tbOriginatorTypeSwitchNode.getRelationType(ctx, new AlarmId(UUID.randomUUID())));
  }
}
