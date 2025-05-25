package org.thingsboard.server.dao.alarm;

import static org.junit.Assert.assertEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.service.validator.AlarmDataValidator;
import org.thingsboard.server.dao.sql.alarm.JpaAlarmDao;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

public class BaseAlarmServiceDiffblueTest {
  /**
   * Test {@link BaseAlarmService#getEntityType()}.
   * <p>
   * Method under test: {@link BaseAlarmService#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType BaseAlarmService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    TenantServiceImpl tenantService = new TenantServiceImpl();
    JpaAlarmDao alarmDao = new JpaAlarmDao();
    BaseEntityService entityService = new BaseEntityService();

    // Act and Assert
    assertEquals(EntityType.ALARM,
        (new BaseAlarmService(tenantService, alarmDao, entityService, new AlarmDataValidator(new TenantServiceImpl())))
            .getEntityType());
  }
}
