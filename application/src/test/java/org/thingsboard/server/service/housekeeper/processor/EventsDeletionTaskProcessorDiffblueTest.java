package org.thingsboard.server.service.housekeeper.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;
import org.thingsboard.server.dao.event.BaseEventService;

class EventsDeletionTaskProcessorDiffblueTest {
  /**
   * Test {@link EventsDeletionTaskProcessor#getTaskType()}.
   *
   * <p>Method under test: {@link EventsDeletionTaskProcessor#getTaskType()}
   */
  @Test
  @DisplayName("Test getTaskType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HousekeeperTaskType EventsDeletionTaskProcessor.getTaskType()"})
  void testGetTaskType() {
    // Arrange, Act and Assert
    assertEquals(
        HousekeeperTaskType.DELETE_EVENTS,
        new EventsDeletionTaskProcessor(new BaseEventService()).getTaskType());
  }
}
