package org.thingsboard.server.service.housekeeper.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.housekeeper.AlarmsDeletionHousekeeperTask;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTask;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.housekeeper.HousekeeperClient;
import org.thingsboard.server.dao.timeseries.BaseTimeseriesService;
import org.thingsboard.server.dao.timeseries.TimeseriesService;

@ContextConfiguration(classes = {TelemetryDeletionTaskProcessor.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class TelemetryDeletionTaskProcessorDiffblueTest {
  @MockBean
  private HousekeeperClient housekeeperClient;

  @Autowired
  private TelemetryDeletionTaskProcessor telemetryDeletionTaskProcessor;

  @MockBean
  private TimeseriesService timeseriesService;

  /**
   * Test {@link TelemetryDeletionTaskProcessor#process(HousekeeperTask)}.
   * <ul>
   *   <li>Given {@link HousekeeperClient}
   * {@link HousekeeperClient#submitTask(HousekeeperTask)} does nothing.</li>
   *   <li>Then calls {@link HousekeeperClient#submitTask(HousekeeperTask)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TelemetryDeletionTaskProcessor#process(HousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(HousekeeperTask); given HousekeeperClient submitTask(HousekeeperTask) does nothing; then calls submitTask(HousekeeperTask)")
  void testProcess_givenHousekeeperClientSubmitTaskDoesNothing_thenCallsSubmitTask() throws Exception {
    // Arrange
    doNothing().when(housekeeperClient).submitTask(Mockito.<HousekeeperTask>any());

    ArrayList<String> stringList = new ArrayList<>();
    stringList.add("[{}][{}][{}] Submitted latest and ts history deletion tasks for {} keys");
    when(timeseriesService.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(stringList);
    AlarmsDeletionHousekeeperTask task = mock(AlarmsDeletionHousekeeperTask.class);
    when(task.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(task.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    telemetryDeletionTaskProcessor.process(task);

    // Assert
    verify(task).getEntityId();
    verify(task).getTenantId();
    verify(housekeeperClient, atLeast(1)).submitTask(Mockito.<HousekeeperTask>any());
    verify(timeseriesService).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link TelemetryDeletionTaskProcessor#process(HousekeeperTask)}.
   * <ul>
   *   <li>Then calls {@link HousekeeperTask#getEntityId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TelemetryDeletionTaskProcessor#process(HousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(HousekeeperTask); then calls getEntityId()")
  void testProcess_thenCallsGetEntityId() throws Exception {
    // Arrange
    when(timeseriesService.findAllKeysByEntityIds(Mockito.<TenantId>any(), Mockito.<List<EntityId>>any()))
        .thenReturn(new ArrayList<>());
    AlarmsDeletionHousekeeperTask task = mock(AlarmsDeletionHousekeeperTask.class);
    when(task.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(task.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    telemetryDeletionTaskProcessor.process(task);

    // Assert
    verify(task).getEntityId();
    verify(task).getTenantId();
    verify(timeseriesService).findAllKeysByEntityIds(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link TelemetryDeletionTaskProcessor#getTaskType()}.
   * <p>
   * Method under test: {@link TelemetryDeletionTaskProcessor#getTaskType()}
   */
  @Test
  @DisplayName("Test getTaskType()")
  void testGetTaskType() {
    // Arrange, Act and Assert
    assertEquals(HousekeeperTaskType.DELETE_TELEMETRY,
        (new TelemetryDeletionTaskProcessor(new BaseTimeseriesService())).getTaskType());
  }
}
