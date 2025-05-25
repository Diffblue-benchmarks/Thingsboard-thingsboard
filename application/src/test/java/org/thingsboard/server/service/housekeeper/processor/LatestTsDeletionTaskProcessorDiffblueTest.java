package org.thingsboard.server.service.housekeeper.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;

class LatestTsDeletionTaskProcessorDiffblueTest {
  /**
   * Test {@link LatestTsDeletionTaskProcessor#getTaskType()}.
   * <p>
   * Method under test: {@link LatestTsDeletionTaskProcessor#getTaskType()}
   */
  @Test
  @DisplayName("Test getTaskType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HousekeeperTaskType LatestTsDeletionTaskProcessor.getTaskType()"})
  void testGetTaskType() {
    // Arrange, Act and Assert
    assertEquals(HousekeeperTaskType.DELETE_LATEST_TS,
        (new LatestTsDeletionTaskProcessor(new BaseTimeseriesService())).getTaskType());
  }
}
