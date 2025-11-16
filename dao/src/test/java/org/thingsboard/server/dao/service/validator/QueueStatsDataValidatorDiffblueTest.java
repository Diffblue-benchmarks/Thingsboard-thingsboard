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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.QueueStats;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {QueueStatsDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class QueueStatsDataValidatorDiffblueTest {
  @Autowired private QueueStatsDataValidator queueStatsDataValidator;

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)} with {@code
   * TenantId}, {@code QueueStats}.
   *
   * <p>Method under test: {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueStatsDataValidator.validateDataImpl(TenantId, QueueStats)"})
  public void testValidateDataImplWithTenantIdQueueStats() {
    // Arrange
    QueueStats queueStats = mock(QueueStats.class);
    when(queueStats.getQueueName()).thenThrow(new DataValidationException("An error occurred"));
    when(queueStats.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queueStats));
    verify(queueStats).getQueueName();
    verify(queueStats).getTenantId();
  }

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)} with {@code
   * TenantId}, {@code QueueStats}.
   *
   * <p>Method under test: {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueStatsDataValidator.validateDataImpl(TenantId, QueueStats)"})
  public void testValidateDataImplWithTenantIdQueueStats2() {
    // Arrange
    QueueStats queueStats = mock(QueueStats.class);
    when(queueStats.getServiceId()).thenThrow(new DataValidationException("An error occurred"));
    when(queueStats.getQueueName()).thenReturn("Queue Name");
    when(queueStats.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queueStats));
    verify(queueStats).getQueueName();
    verify(queueStats).getServiceId();
    verify(queueStats).getTenantId();
  }

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)} with {@code
   * TenantId}, {@code QueueStats}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueStatsDataValidator.validateDataImpl(TenantId, QueueStats)"})
  public void testValidateDataImplWithTenantIdQueueStats_given42() {
    // Arrange
    QueueStats queueStats = mock(QueueStats.class);
    when(queueStats.getServiceId()).thenReturn("42");
    when(queueStats.getQueueName()).thenReturn("Queue Name");
    when(queueStats.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queueStats);

    // Assert
    verify(queueStats).getQueueName();
    verify(queueStats).getServiceId();
    verify(queueStats).getTenantId();
  }

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)} with {@code
   * TenantId}, {@code QueueStats}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueStatsDataValidator.validateDataImpl(TenantId, QueueStats)"})
  public void testValidateDataImplWithTenantIdQueueStats_givenEmptyString() {
    // Arrange
    QueueStats queueStats = mock(QueueStats.class);
    when(queueStats.getServiceId()).thenReturn("");
    when(queueStats.getQueueName()).thenReturn("Queue Name");
    when(queueStats.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queueStats));
    verify(queueStats).getQueueName();
    verify(queueStats).getServiceId();
    verify(queueStats).getTenantId();
  }

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)} with {@code
   * TenantId}, {@code QueueStats}.
   *
   * <ul>
   *   <li>When {@link QueueStats#QueueStats()}.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueStatsDataValidator.validateDataImpl(TenantId, QueueStats)"})
  public void testValidateDataImplWithTenantIdQueueStats_whenQueueStats() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            queueStatsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new QueueStats()));
  }

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)} with {@code
   * TenantId}, {@code QueueStats}.
   *
   * <ul>
   *   <li>When {@link QueueStats} {@link QueueStats#getQueueName()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueStatsDataValidator.validateDataImpl(TenantId, QueueStats)"})
  public void testValidateDataImplWithTenantIdQueueStats_whenQueueStatsGetQueueNameReturnNull() {
    // Arrange
    QueueStats queueStats = mock(QueueStats.class);
    when(queueStats.getQueueName()).thenReturn(null);
    when(queueStats.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queueStats));
    verify(queueStats).getQueueName();
    verify(queueStats).getTenantId();
  }

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)} with {@code
   * TenantId}, {@code QueueStats}.
   *
   * <ul>
   *   <li>When {@link QueueStats} {@link QueueStats#getServiceId()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueStatsDataValidator.validateDataImpl(TenantId, QueueStats)"})
  public void testValidateDataImplWithTenantIdQueueStats_whenQueueStatsGetServiceIdReturnNull() {
    // Arrange
    QueueStats queueStats = mock(QueueStats.class);
    when(queueStats.getServiceId()).thenReturn(null);
    when(queueStats.getQueueName()).thenReturn("Queue Name");
    when(queueStats.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queueStats));
    verify(queueStats).getQueueName();
    verify(queueStats).getServiceId();
    verify(queueStats).getTenantId();
  }
}
