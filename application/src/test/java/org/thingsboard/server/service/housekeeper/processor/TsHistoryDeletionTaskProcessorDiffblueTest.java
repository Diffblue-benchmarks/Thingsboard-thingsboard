package org.thingsboard.server.service.housekeeper.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;

class TsHistoryDeletionTaskProcessorDiffblueTest {
  /**
   * Test {@link TsHistoryDeletionTaskProcessor#getTaskType()}.
   * <p>
   * Method under test: {@link TsHistoryDeletionTaskProcessor#getTaskType()}
   */
  @Test
  @DisplayName("Test getTaskType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HousekeeperTaskType TsHistoryDeletionTaskProcessor.getTaskType()"})
  void testGetTaskType() {
    // Arrange, Act and Assert
    assertEquals(HousekeeperTaskType.DELETE_TS_HISTORY,
        (new TsHistoryDeletionTaskProcessor(new BaseTimeseriesService())).getTaskType());
  }
}
