package org.thingsboard.server.service.housekeeper.processor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;
import org.thingsboard.server.dao.alarm.BaseAlarmService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.service.validator.AlarmDataValidator;
import org.thingsboard.server.dao.sql.alarm.JpaAlarmDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

class AlarmsDeletionTaskProcessorDiffblueTest {
  /**
   * Test {@link AlarmsDeletionTaskProcessor#getTaskType()}.
   * <p>
   * Method under test: {@link AlarmsDeletionTaskProcessor#getTaskType()}
   */
  @Test
  @DisplayName("Test getTaskType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"HousekeeperTaskType AlarmsDeletionTaskProcessor.getTaskType()"})
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
