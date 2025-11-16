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
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.queue.QueueDao;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;

@ContextConfiguration(classes = {QueueValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class QueueValidatorDiffblueTest {
  @MockBean private QueueDao queueDao;

  @Autowired private QueueValidator queueValidator;

  @MockBean private TbTenantProfileCache tbTenantProfileCache;

  /**
   * Test {@link QueueValidator#validateCreate(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <p>Method under test: {@link QueueValidator#validateCreate(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateCreate(TenantId, Queue)"})
  public void testValidateCreateWithTenantIdQueue() {
    // Arrange
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Queue()));
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link QueueValidator#validateCreate(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link QueueValidator#validateCreate(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateCreate(TenantId, Queue)"})
  public void testValidateCreateWithTenantIdQueue_thenThrowDataValidationException() {
    // Arrange
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new Queue());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Queue()));
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), isNull());
  }
}
