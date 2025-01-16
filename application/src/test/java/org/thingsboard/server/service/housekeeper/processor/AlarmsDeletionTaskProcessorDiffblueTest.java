package org.thingsboard.server.service.housekeeper.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
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
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.AssetId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.housekeeper.HousekeeperClient;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.alarm.BaseAlarmService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.service.validator.AlarmDataValidator;
import org.thingsboard.server.dao.sql.alarm.JpaAlarmDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

@ContextConfiguration(classes = {AlarmsDeletionTaskProcessor.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AlarmsDeletionTaskProcessorDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @Autowired
  private AlarmsDeletionTaskProcessor alarmsDeletionTaskProcessor;

  @MockBean
  private HousekeeperClient housekeeperClient;

  /**
   * Test
   * {@link AlarmsDeletionTaskProcessor#process(AlarmsDeletionHousekeeperTask)}
   * with {@code AlarmsDeletionHousekeeperTask}.
   * <ul>
   *   <li>Given {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmsDeletionTaskProcessor#process(AlarmsDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(AlarmsDeletionHousekeeperTask) with 'AlarmsDeletionHousekeeperTask'; given AlarmId(UUID) with id is randomUUID")
  void testProcessWithAlarmsDeletionHousekeeperTask_givenAlarmIdWithIdIsRandomUUID() throws Exception {
    // Arrange
    when(alarmService.deleteEntityAlarmRecords(Mockito.<TenantId>any(), Mockito.<EntityId>any())).thenReturn(1);
    AlarmsDeletionHousekeeperTask task = mock(AlarmsDeletionHousekeeperTask.class);
    when(task.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(task.getEntityId()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    alarmsDeletionTaskProcessor.process(task);

    // Assert
    verify(task).getEntityId();
    verify(task).getTenantId();
    verify(alarmService).deleteEntityAlarmRecords(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test
   * {@link AlarmsDeletionTaskProcessor#process(AlarmsDeletionHousekeeperTask)}
   * with {@code AlarmsDeletionHousekeeperTask}.
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.</li>
   *   <li>Then calls {@link AlarmsDeletionHousekeeperTask#getAlarms()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmsDeletionTaskProcessor#process(AlarmsDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(AlarmsDeletionHousekeeperTask) with 'AlarmsDeletionHousekeeperTask'; given ArrayList(); then calls getAlarms()")
  void testProcessWithAlarmsDeletionHousekeeperTask_givenArrayList_thenCallsGetAlarms() throws Exception {
    // Arrange
    when(alarmService.deleteEntityAlarmRecords(Mockito.<TenantId>any(), Mockito.<EntityId>any())).thenReturn(1);
    AlarmsDeletionHousekeeperTask task = mock(AlarmsDeletionHousekeeperTask.class);
    when(task.getAlarms()).thenReturn(new ArrayList<>());
    when(task.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(task.getEntityId()).thenReturn(new AssetId(UUID.randomUUID()));

    // Act
    alarmsDeletionTaskProcessor.process(task);

    // Assert
    verify(task, atLeast(1)).getAlarms();
    verify(task).getEntityId();
    verify(task).getTenantId();
    verify(alarmService).deleteEntityAlarmRecords(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test
   * {@link AlarmsDeletionTaskProcessor#process(AlarmsDeletionHousekeeperTask)}
   * with {@code AlarmsDeletionHousekeeperTask}.
   * <ul>
   *   <li>Then calls
   * {@link AlarmService#findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmsDeletionTaskProcessor#process(AlarmsDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(AlarmsDeletionHousekeeperTask) with 'AlarmsDeletionHousekeeperTask'; then calls findAlarmIdsByOriginatorId(TenantId, EntityId, long, AlarmId, int)")
  void testProcessWithAlarmsDeletionHousekeeperTask_thenCallsFindAlarmIdsByOriginatorId() throws Exception {
    // Arrange
    when(alarmService.findAlarmIdsByOriginatorId(Mockito.<TenantId>any(), Mockito.<EntityId>any(), anyLong(),
        Mockito.<AlarmId>any(), anyInt())).thenReturn(new ArrayList<>());
    when(alarmService.deleteEntityAlarmRecords(Mockito.<TenantId>any(), Mockito.<EntityId>any())).thenReturn(1);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    alarmsDeletionTaskProcessor.process(new AlarmsDeletionHousekeeperTask(tenantId, new AssetId(UUID.randomUUID())));

    // Assert
    verify(alarmService).deleteEntityAlarmRecords(isA(TenantId.class), isA(EntityId.class));
    verify(alarmService).findAlarmIdsByOriginatorId(isA(TenantId.class), isA(EntityId.class), eq(0L), isNull(),
        eq(128));
  }

  /**
   * Test
   * {@link AlarmsDeletionTaskProcessor#process(AlarmsDeletionHousekeeperTask)}
   * with {@code AlarmsDeletionHousekeeperTask}.
   * <ul>
   *   <li>When {@link AlarmId#AlarmId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmsDeletionTaskProcessor#process(AlarmsDeletionHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(AlarmsDeletionHousekeeperTask) with 'AlarmsDeletionHousekeeperTask'; when AlarmId(UUID) with id is randomUUID")
  void testProcessWithAlarmsDeletionHousekeeperTask_whenAlarmIdWithIdIsRandomUUID() throws Exception {
    // Arrange
    when(alarmService.deleteEntityAlarmRecords(Mockito.<TenantId>any(), Mockito.<EntityId>any())).thenReturn(1);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    alarmsDeletionTaskProcessor.process(new AlarmsDeletionHousekeeperTask(tenantId, new AlarmId(UUID.randomUUID())));

    // Assert
    verify(alarmService).deleteEntityAlarmRecords(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link AlarmsDeletionTaskProcessor#getTaskType()}.
   * <p>
   * Method under test: {@link AlarmsDeletionTaskProcessor#getTaskType()}
   */
  @Test
  @DisplayName("Test getTaskType()")
  void testGetTaskType() {
    // Arrange
    TenantServiceImpl tenantService = new TenantServiceImpl();
    JpaAlarmDao alarmDao = new JpaAlarmDao();
    BaseEntityService entityService = new BaseEntityService();

    // Act and Assert
    assertEquals(HousekeeperTaskType.DELETE_ALARMS, (new AlarmsDeletionTaskProcessor(
        new BaseAlarmService(tenantService, alarmDao, entityService, new AlarmDataValidator(new TenantServiceImpl()))))
        .getTaskType());
  }
}
