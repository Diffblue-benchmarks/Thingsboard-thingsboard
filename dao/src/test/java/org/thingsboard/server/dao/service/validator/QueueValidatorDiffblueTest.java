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
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
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
import org.thingsboard.server.common.data.queue.ProcessingStrategy;
import org.thingsboard.server.common.data.queue.ProcessingStrategyType;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.data.queue.SubmitStrategy;
import org.thingsboard.server.common.data.queue.SubmitStrategyType;
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
        .thenReturn(new Queue());

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
   * <p>Method under test: {@link QueueValidator#validateCreate(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateCreate(TenantId, Queue)"})
  public void testValidateCreateWithTenantIdQueue2() {
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
   * <p>Method under test: {@link QueueValidator#validateCreate(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateCreate(TenantId, Queue)"})
  public void testValidateCreateWithTenantIdQueue3() {
    // Arrange
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    when(queueDao.findQueueByTenantIdAndTopic(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);

    // Act
    queueValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Queue());

    // Assert
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), isNull());
    verify(queueDao).findQueueByTenantIdAndTopic(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link QueueValidator#validateCreate(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <ul>
   *   <li>Then calls {@link QueueDao#findQueueByTenantIdAndTopic(TenantId, String)}.
   * </ul>
   *
   * <p>Method under test: {@link QueueValidator#validateCreate(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateCreate(TenantId, Queue)"})
  public void testValidateCreateWithTenantIdQueue_thenCallsFindQueueByTenantIdAndTopic() {
    // Arrange
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);
    when(queueDao.findQueueByTenantIdAndTopic(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new Queue());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Queue()));
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), isNull());
    verify(queueDao).findQueueByTenantIdAndTopic(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link QueueValidator#validateUpdate(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <p>Method under test: {@link QueueValidator#validateUpdate(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue QueueValidator.validateUpdate(TenantId, Queue)"})
  public void testValidateUpdateWithTenantIdQueue() {
    // Arrange
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new Queue()));
    verify(queueDao).findById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link QueueValidator#validateUpdate(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <ul>
   *   <li>Given {@link QueueDao} {@link QueueDao#findById(TenantId, UUID)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link QueueValidator#validateUpdate(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue QueueValidator.validateUpdate(TenantId, Queue)"})
  public void testValidateUpdateWithTenantIdQueue_givenQueueDaoFindByIdReturnNull() {
    // Arrange
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new Queue()));
    verify(queueDao, atLeast(1)).findById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link QueueValidator#validateUpdate(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <ul>
   *   <li>Given {@link Queue#Queue()} Name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link QueueValidator#validateUpdate(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue QueueValidator.validateUpdate(TenantId, Queue)"})
  public void testValidateUpdateWithTenantIdQueue_givenQueueNameIsName() {
    // Arrange
    Queue queue = new Queue();
    queue.setName("Name");
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queue);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new Queue()));
    verify(queueDao, atLeast(1)).findById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link QueueValidator#validateUpdate(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <ul>
   *   <li>Then calls {@link Queue#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link QueueValidator#validateUpdate(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue QueueValidator.validateUpdate(TenantId, Queue)"})
  public void testValidateUpdateWithTenantIdQueue_thenCallsGetName() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.getName()).thenThrow(new DataValidationException("An error occurred"));
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queue);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new Queue()));
    verify(queue).getName();
    verify(queueDao, atLeast(1)).findById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.getTopic()).thenThrow(new DataValidationException("An error occurred"));
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue2() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.getPollInterval()).thenThrow(new DataValidationException("An error occurred"));
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPollInterval();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue3() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.getPartitions()).thenThrow(new DataValidationException("An error occurred"));
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue4() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.getPackProcessingTimeout()).thenReturn(0L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue5() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.getPackProcessingTimeout())
        .thenThrow(new DataValidationException("An error occurred"));
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue6() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.getSubmitStrategy()).thenThrow(new DataValidationException("An error occurred"));
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue7() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setType(SubmitStrategyType.BATCH);
    submitStrategy.setBatchSize(1);

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    processingStrategy.setRetries(0);
    processingStrategy.setFailurePercentage(0.0d);
    processingStrategy.setPauseBetweenRetries(-1L);

    Queue queue = mock(Queue.class);
    when(queue.getProcessingStrategy()).thenReturn(processingStrategy);
    when(queue.getSubmitStrategy()).thenReturn(submitStrategy);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getProcessingStrategy();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue8() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setType(SubmitStrategyType.BATCH);
    submitStrategy.setBatchSize(1);

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    processingStrategy.setRetries(0);
    processingStrategy.setFailurePercentage(-1.0E-10d);
    processingStrategy.setPauseBetweenRetries(0L);

    Queue queue = mock(Queue.class);
    when(queue.getProcessingStrategy()).thenReturn(processingStrategy);
    when(queue.getSubmitStrategy()).thenReturn(submitStrategy);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getProcessingStrategy();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue9() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setType(SubmitStrategyType.BATCH);
    submitStrategy.setBatchSize(1);

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    processingStrategy.setRetries(0);
    processingStrategy.setFailurePercentage(100.00000000000001d);
    processingStrategy.setPauseBetweenRetries(0L);

    Queue queue = mock(Queue.class);
    when(queue.getProcessingStrategy()).thenReturn(processingStrategy);
    when(queue.getSubmitStrategy()).thenReturn(submitStrategy);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getProcessingStrategy();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue10() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setType(SubmitStrategyType.BATCH);
    submitStrategy.setBatchSize(1);

    Queue queue = mock(Queue.class);
    when(queue.getProcessingStrategy()).thenThrow(new DataValidationException("An error occurred"));
    when(queue.getSubmitStrategy()).thenReturn(submitStrategy);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getProcessingStrategy();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <ul>
   *   <li>Given {@link ProcessingStrategy} (default constructor) Retries is minus one.
   * </ul>
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue_givenProcessingStrategyRetriesIsMinusOne() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setType(SubmitStrategyType.BATCH);
    submitStrategy.setBatchSize(1);

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    processingStrategy.setRetries(-1);
    processingStrategy.setFailurePercentage(0.0d);
    processingStrategy.setPauseBetweenRetries(0L);

    Queue queue = mock(Queue.class);
    when(queue.getProcessingStrategy()).thenReturn(processingStrategy);
    when(queue.getSubmitStrategy()).thenReturn(submitStrategy);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getProcessingStrategy();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <ul>
   *   <li>Given {@link ProcessingStrategy} (default constructor) Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue_givenProcessingStrategyTypeIsNull() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setType(SubmitStrategyType.BATCH);
    submitStrategy.setBatchSize(1);

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setType(null);
    processingStrategy.setRetries(0);
    processingStrategy.setFailurePercentage(0.0d);
    processingStrategy.setPauseBetweenRetries(0L);

    Queue queue = mock(Queue.class);
    when(queue.getProcessingStrategy()).thenReturn(processingStrategy);
    when(queue.getSubmitStrategy()).thenReturn(submitStrategy);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getProcessingStrategy();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <ul>
   *   <li>Given {@link QueueValidator} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue_givenQueueValidator() {
    // Arrange
    QueueValidator queueValidator = new QueueValidator();

    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setType(SubmitStrategyType.BATCH);
    submitStrategy.setBatchSize(1);

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setMaxPauseBetweenRetries(-1L);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    processingStrategy.setRetries(0);
    processingStrategy.setFailurePercentage(0.0d);
    processingStrategy.setPauseBetweenRetries(0L);

    Queue queue = mock(Queue.class);
    when(queue.getProcessingStrategy()).thenReturn(processingStrategy);
    when(queue.getSubmitStrategy()).thenReturn(submitStrategy);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getProcessingStrategy();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <ul>
   *   <li>Given {@link SubmitStrategy} (default constructor) BatchSize is zero.
   * </ul>
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue_givenSubmitStrategyBatchSizeIsZero() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setType(SubmitStrategyType.BATCH);
    submitStrategy.setBatchSize(0);

    Queue queue = mock(Queue.class);
    when(queue.getSubmitStrategy()).thenReturn(submitStrategy);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <ul>
   *   <li>Given {@link SubmitStrategy} (default constructor) Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue_givenSubmitStrategyTypeIsNull() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setType(null);
    submitStrategy.setBatchSize(1);

    Queue queue = mock(Queue.class);
    when(queue.getSubmitStrategy()).thenReturn(submitStrategy);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <ul>
   *   <li>Given zero.
   *   <li>When {@link Queue} {@link Queue#getPartitions()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue_givenZero_whenQueueGetPartitionsReturnZero() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.getPartitions()).thenReturn(0);
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <ul>
   *   <li>When {@link Queue} {@link Queue#getPollInterval()} return zero.
   * </ul>
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue_whenQueueGetPollIntervalReturnZero() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.getPollInterval()).thenReturn(0);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPollInterval();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <ul>
   *   <li>When {@link Queue} {@link Queue#getProcessingStrategy()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue_whenQueueGetProcessingStrategyReturnNull() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setType(SubmitStrategyType.BATCH);
    submitStrategy.setBatchSize(1);

    Queue queue = mock(Queue.class);
    when(queue.getProcessingStrategy()).thenReturn(null);
    when(queue.getSubmitStrategy()).thenReturn(submitStrategy);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getProcessingStrategy();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <ul>
   *   <li>When {@link Queue} {@link Queue#getSubmitStrategy()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue_whenQueueGetSubmitStrategyReturnNull() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.getSubmitStrategy()).thenReturn(null);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(1);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with {@code TenantId}, {@code
   * Queue}.
   *
   * <ul>
   *   <li>When {@link Queue#Queue()}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void QueueValidator.validateDataImpl(TenantId, Queue)"})
  public void testValidateDataImplWithTenantIdQueue_whenQueue_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new Queue()));
  }
}
