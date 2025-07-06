package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.audit.AuditLog;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {AuditLogDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AuditLogDataValidatorDiffblueTest {
  @Autowired private AuditLogDataValidator auditLogDataValidator;

  /**
   * Test {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)} with {@code TenantId},
   * {@code AuditLog}.
   *
   * <p>Method under test: {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AuditLogDataValidator.validateDataImpl(TenantId, AuditLog)"})
  public void testValidateDataImplWithTenantIdAuditLog() {
    // Arrange
    AuditLog auditLog = new AuditLog(new AuditLog());
    auditLog.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    auditLog.setTenantId(null);
    auditLog.setUserId(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> auditLogDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, auditLog));
  }

  /**
   * Test {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)} with {@code TenantId},
   * {@code AuditLog}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AuditLogDataValidator.validateDataImpl(TenantId, AuditLog)"})
  public void testValidateDataImplWithTenantIdAuditLog_givenSystem_tenant() {
    // Arrange
    AuditLog auditLog = new AuditLog(new AuditLog());
    auditLog.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    auditLog.setTenantId(ModelConstants.SYSTEM_TENANT);
    auditLog.setUserId(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> auditLogDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, auditLog));
  }

  /**
   * Test {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)} with {@code TenantId},
   * {@code AuditLog}.
   *
   * <ul>
   *   <li>When {@link AuditLog#AuditLog()}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AuditLogDataValidator.validateDataImpl(TenantId, AuditLog)"})
  public void testValidateDataImplWithTenantIdAuditLog_whenAuditLog() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> auditLogDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new AuditLog()));
  }
}
