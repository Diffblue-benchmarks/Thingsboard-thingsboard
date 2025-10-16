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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AuditLogDataValidator.validateDataImpl(TenantId, AuditLog)"})
  public void testValidateDataImplWithTenantIdAuditLog_whenAuditLog() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> auditLogDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new AuditLog()));
  }
}
