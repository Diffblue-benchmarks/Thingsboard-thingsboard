package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.audit.AuditLog;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {AuditLogDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class AuditLogDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @Autowired
  private AuditLogDataValidator auditLogDataValidator;

  /**
   * Test {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)} with
   * {@code TenantId}, {@code AuditLog}.
   * <p>
   * Method under test:
   * {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAuditLog() {
    // Arrange
    AuditLog auditLog = mock(AuditLog.class);
    when(auditLog.getUserId()).thenThrow(new DataValidationException("An error occurred"));
    when(auditLog.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(auditLog.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> auditLogDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, auditLog));
    verify(auditLog).getEntityId();
    verify(auditLog).getTenantId();
    verify(auditLog).getUserId();
  }

  /**
   * Test {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)} with
   * {@code TenantId}, {@code AuditLog}.
   * <ul>
   *   <li>Given {@link UserId#UserId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAuditLog_givenUserIdWithIdIsNull_uuid() {
    // Arrange
    AuditLog auditLog = mock(AuditLog.class);
    when(auditLog.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));
    when(auditLog.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(auditLog.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    auditLogDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, auditLog);

    // Assert that nothing has changed
    verify(auditLog).getEntityId();
    verify(auditLog).getTenantId();
    verify(auditLog).getUserId();
  }

  /**
   * Test {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)} with
   * {@code TenantId}, {@code AuditLog}.
   * <ul>
   *   <li>When {@link AuditLog#AuditLog()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAuditLog_whenAuditLog() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> auditLogDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new AuditLog()));
  }

  /**
   * Test {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)} with
   * {@code TenantId}, {@code AuditLog}.
   * <ul>
   *   <li>When {@link AuditLog} {@link AuditLog#getTenantId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAuditLog_whenAuditLogGetTenantIdReturnNull() {
    // Arrange
    AuditLog auditLog = mock(AuditLog.class);
    when(auditLog.getTenantId()).thenReturn(null);
    when(auditLog.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> auditLogDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, auditLog));
    verify(auditLog).getEntityId();
    verify(auditLog).getTenantId();
  }

  /**
   * Test {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)} with
   * {@code TenantId}, {@code AuditLog}.
   * <ul>
   *   <li>When {@link AuditLog} {@link AuditLog#getUserId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAuditLog_whenAuditLogGetUserIdReturnNull() {
    // Arrange
    AuditLog auditLog = mock(AuditLog.class);
    when(auditLog.getUserId()).thenReturn(null);
    when(auditLog.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(auditLog.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> auditLogDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, auditLog));
    verify(auditLog).getEntityId();
    verify(auditLog).getTenantId();
    verify(auditLog).getUserId();
  }
}
