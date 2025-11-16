/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.audit.AuditLog;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuditLogDataValidator.validateDataImpl(TenantId, AuditLog)"})
  public void testValidateDataImplWithTenantIdAuditLog() {
    // Arrange
    AuditLogDataValidator auditLogDataValidator = new AuditLogDataValidator();

    AuditLog auditLog = mock(AuditLog.class);
    when(auditLog.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(auditLog.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> auditLogDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, auditLog));
    verify(auditLog).getEntityId();
    verify(auditLog).getTenantId();
  }

  /**
   * Test {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)} with {@code TenantId},
   * {@code AuditLog}.
   *
   * <p>Method under test: {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuditLogDataValidator.validateDataImpl(TenantId, AuditLog)"})
  public void testValidateDataImplWithTenantIdAuditLog2() {
    // Arrange
    AuditLogDataValidator auditLogDataValidator = new AuditLogDataValidator();

    AuditLog auditLog = mock(AuditLog.class);
    when(auditLog.getUserId()).thenThrow(new DataValidationException("An error occurred"));
    when(auditLog.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(auditLog.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> auditLogDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, auditLog));
    verify(auditLog).getEntityId();
    verify(auditLog).getTenantId();
    verify(auditLog).getUserId();
  }

  /**
   * Test {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)} with {@code TenantId},
   * {@code AuditLog}.
   *
   * <ul>
   *   <li>Given {@link AuditLogDataValidator}.
   *   <li>When {@link AuditLog#AuditLog()}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuditLogDataValidator.validateDataImpl(TenantId, AuditLog)"})
  public void testValidateDataImplWithTenantIdAuditLog_givenAuditLogDataValidator_whenAuditLog() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> auditLogDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new AuditLog()));
  }

  /**
   * Test {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)} with {@code TenantId},
   * {@code AuditLog}.
   *
   * <ul>
   *   <li>Given {@link UserId#UserId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuditLogDataValidator.validateDataImpl(TenantId, AuditLog)"})
  public void testValidateDataImplWithTenantIdAuditLog_givenUserIdWithIdIsNull_uuid() {
    // Arrange
    AuditLogDataValidator auditLogDataValidator = new AuditLogDataValidator();

    AuditLog auditLog = mock(AuditLog.class);
    when(auditLog.getUserId()).thenReturn(new UserId(ModelConstants.NULL_UUID));
    when(auditLog.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(auditLog.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    auditLogDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, auditLog);

    // Assert
    verify(auditLog).getEntityId();
    verify(auditLog).getTenantId();
    verify(auditLog).getUserId();
  }

  /**
   * Test {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)} with {@code TenantId},
   * {@code AuditLog}.
   *
   * <ul>
   *   <li>When {@link AuditLog} {@link AuditLog#getTenantId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuditLogDataValidator.validateDataImpl(TenantId, AuditLog)"})
  public void testValidateDataImplWithTenantIdAuditLog_whenAuditLogGetTenantIdReturnNull() {
    // Arrange
    AuditLogDataValidator auditLogDataValidator = new AuditLogDataValidator();

    AuditLog auditLog = mock(AuditLog.class);
    when(auditLog.getTenantId()).thenReturn(null);
    when(auditLog.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> auditLogDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, auditLog));
    verify(auditLog).getEntityId();
    verify(auditLog).getTenantId();
  }

  /**
   * Test {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)} with {@code TenantId},
   * {@code AuditLog}.
   *
   * <ul>
   *   <li>When {@link AuditLog} {@link AuditLog#getUserId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogDataValidator#validateDataImpl(TenantId, AuditLog)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuditLogDataValidator.validateDataImpl(TenantId, AuditLog)"})
  public void testValidateDataImplWithTenantIdAuditLog_whenAuditLogGetUserIdReturnNull() {
    // Arrange
    AuditLogDataValidator auditLogDataValidator = new AuditLogDataValidator();

    AuditLog auditLog = mock(AuditLog.class);
    when(auditLog.getUserId()).thenReturn(null);
    when(auditLog.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(auditLog.getEntityId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> auditLogDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, auditLog));
    verify(auditLog).getEntityId();
    verify(auditLog).getTenantId();
    verify(auditLog).getUserId();
  }
}
