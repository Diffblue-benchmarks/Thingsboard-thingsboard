package org.thingsboard.rule.engine.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.rule.engine.api.TbContext;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;

class TbOriginatorTypeSwitchNodeDiffblueTest {
  /**
   * Test {@link TbOriginatorTypeSwitchNode#getRelationType(TbContext, EntityId)}.
   * <ul>
   *   <li>Then return {@code Alarm}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbOriginatorTypeSwitchNode#getRelationType(TbContext, EntityId)}
   */
  @Test
  @DisplayName("Test getRelationType(TbContext, EntityId); then return 'Alarm'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String TbOriginatorTypeSwitchNode.getRelationType(TbContext, EntityId)"})
  void testGetRelationType_thenReturnAlarm() {
    // Arrange
    TbOriginatorTypeSwitchNode tbOriginatorTypeSwitchNode = new TbOriginatorTypeSwitchNode();
    TbContext ctx = mock(TbContext.class);

    // Act and Assert
    assertEquals("Alarm", tbOriginatorTypeSwitchNode.getRelationType(ctx,
        new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }
}
