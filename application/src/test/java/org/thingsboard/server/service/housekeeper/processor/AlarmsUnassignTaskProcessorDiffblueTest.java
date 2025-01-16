package org.thingsboard.server.service.housekeeper.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
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
import org.thingsboard.server.common.data.housekeeper.AlarmsUnassignHousekeeperTask;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.msg.housekeeper.HousekeeperClient;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.alarm.BaseAlarmCommentService;
import org.thingsboard.server.dao.alarm.BaseAlarmService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.service.validator.AlarmDataValidator;
import org.thingsboard.server.dao.sql.alarm.JpaAlarmDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;
import org.thingsboard.server.service.entitiy.alarm.DefaultTbAlarmCommentService;
import org.thingsboard.server.service.entitiy.alarm.DefaultTbAlarmService;
import org.thingsboard.server.service.entitiy.alarm.TbAlarmService;

@ContextConfiguration(classes = {AlarmsUnassignTaskProcessor.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AlarmsUnassignTaskProcessorDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @Autowired
  private AlarmsUnassignTaskProcessor alarmsUnassignTaskProcessor;

  @MockBean
  private HousekeeperClient housekeeperClient;

  @MockBean
  private TbAlarmService tbAlarmService;

  /**
   * Test
   * {@link AlarmsUnassignTaskProcessor#process(AlarmsUnassignHousekeeperTask)}
   * with {@code AlarmsUnassignHousekeeperTask}.
   * <ul>
   *   <li>Given {@code Dr}.</li>
   *   <li>Then calls {@link AlarmsUnassignHousekeeperTask#getAlarms()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AlarmsUnassignTaskProcessor#process(AlarmsUnassignHousekeeperTask)}
   */
  @Test
  @DisplayName("Test process(AlarmsUnassignHousekeeperTask) with 'AlarmsUnassignHousekeeperTask'; given 'Dr'; then calls getAlarms()")
  void testProcessWithAlarmsUnassignHousekeeperTask_givenDr_thenCallsGetAlarms() throws Exception {
    // Arrange
    doNothing().when(tbAlarmService)
        .unassignDeletedUserAlarms(Mockito.<TenantId>any(), Mockito.<UserId>any(), Mockito.<String>any(),
            Mockito.<List<UUID>>any(), anyLong());
    AlarmsUnassignHousekeeperTask task = mock(AlarmsUnassignHousekeeperTask.class);
    when(task.getUserTitle()).thenReturn("Dr");
    when(task.getAlarms()).thenReturn(new ArrayList<>());
    when(task.getTs()).thenReturn(1L);
    when(task.getEntityId()).thenReturn(null);
    when(task.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));

    // Act
    alarmsUnassignTaskProcessor.process(task);

    // Assert
    verify(task, atLeast(1)).getAlarms();
    verify(task).getUserTitle();
    verify(task).getEntityId();
    verify(task).getTenantId();
    verify(task).getTs();
    verify(tbAlarmService).unassignDeletedUserAlarms(isA(TenantId.class), isNull(), eq("Dr"), isA(List.class), eq(1L));
  }

  /**
   * Test {@link AlarmsUnassignTaskProcessor#getTaskType()}.
   * <p>
   * Method under test: {@link AlarmsUnassignTaskProcessor#getTaskType()}
   */
  @Test
  @DisplayName("Test getTaskType()")
  void testGetTaskType() {
    // Arrange
    DefaultTbAlarmService tbAlarmService = new DefaultTbAlarmService(
        new DefaultTbAlarmCommentService(new BaseAlarmCommentService()));
    TenantServiceImpl tenantService = new TenantServiceImpl();
    JpaAlarmDao alarmDao = new JpaAlarmDao();
    BaseEntityService entityService = new BaseEntityService();

    // Act and Assert
    assertEquals(HousekeeperTaskType.UNASSIGN_ALARMS, (new AlarmsUnassignTaskProcessor(tbAlarmService,
        new BaseAlarmService(tenantService, alarmDao, entityService, new AlarmDataValidator(new TenantServiceImpl()))))
        .getTaskType());
  }
}
