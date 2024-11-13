package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
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
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.queue.QueueDao;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {QueueValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class QueueValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private QueueDao queueDao;

  @Autowired
  private QueueValidator queueValidator;

  @MockBean
  private TbTenantProfileCache tbTenantProfileCache;

  /**
   * Test {@link QueueValidator#validateCreate(TenantId, Queue)} with
   * {@code TenantId}, {@code Queue}.
   * <p>
   * Method under test: {@link QueueValidator#validateCreate(TenantId, Queue)}
   */
  @Test
  public void testValidateCreateWithTenantIdQueue() {
    // Arrange
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(new Queue());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Queue()));
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link QueueValidator#validateCreate(TenantId, Queue)} with
   * {@code TenantId}, {@code Queue}.
   * <p>
   * Method under test: {@link QueueValidator#validateCreate(TenantId, Queue)}
   */
  @Test
  public void testValidateCreateWithTenantIdQueue2() {
    // Arrange
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Queue()));
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link QueueValidator#validateCreate(TenantId, Queue)} with
   * {@code TenantId}, {@code Queue}.
   * <p>
   * Method under test: {@link QueueValidator#validateCreate(TenantId, Queue)}
   */
  @Test
  public void testValidateCreateWithTenantIdQueue3() {
    // Arrange
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    when(queueDao.findQueueByTenantIdAndTopic(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);

    // Act
    queueValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Queue());

    // Assert that nothing has changed
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), isNull());
    verify(queueDao).findQueueByTenantIdAndTopic(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link QueueValidator#validateCreate(TenantId, Queue)} with
   * {@code TenantId}, {@code Queue}.
   * <ul>
   *   <li>Then calls
   * {@link QueueDao#findQueueByTenantIdAndTopic(TenantId, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueValidator#validateCreate(TenantId, Queue)}
   */
  @Test
  public void testValidateCreateWithTenantIdQueue_thenCallsFindQueueByTenantIdAndTopic() {
    // Arrange
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    when(queueDao.findQueueByTenantIdAndTopic(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(new Queue());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new Queue()));
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), isNull());
    verify(queueDao).findQueueByTenantIdAndTopic(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link QueueValidator#validateUpdate(TenantId, Queue)} with
   * {@code TenantId}, {@code Queue}.
   * <ul>
   *   <li>Given {@link QueueDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueValidator#validateUpdate(TenantId, Queue)}
   */
  @Test
  public void testValidateUpdateWithTenantIdQueue_givenQueueDaoFindByIdReturnNull() {
    // Arrange
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new Queue()));
    verify(queueDao, atLeast(1)).findById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link QueueValidator#validateUpdate(TenantId, Queue)} with
   * {@code TenantId}, {@code Queue}.
   * <ul>
   *   <li>Given {@link Queue#Queue()} Name is {@code Name}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueValidator#validateUpdate(TenantId, Queue)}
   */
  @Test
  public void testValidateUpdateWithTenantIdQueue_givenQueueNameIsName() {
    // Arrange
    Queue queue = new Queue();
    queue.setName("Name");
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queue);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new Queue()));
    verify(queueDao, atLeast(1)).findById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link QueueValidator#validateUpdate(TenantId, Queue)} with
   * {@code TenantId}, {@code Queue}.
   * <ul>
   *   <li>Then calls {@link Queue#getName()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueValidator#validateUpdate(TenantId, Queue)}
   */
  @Test
  public void testValidateUpdateWithTenantIdQueue_thenCallsGetName() {
    // Arrange
    Queue queue = mock(Queue.class);
    when(queue.getName()).thenThrow(new DataValidationException("An error occurred"));
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queue);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new Queue()));
    verify(queue).getName();
    verify(queueDao, atLeast(1)).findById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with
   * {@code TenantId}, {@code Queue}.
   * <p>
   * Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  public void testValidateDataImplWithTenantIdQueue() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);

    ProcessingStrategy processingStrategy = new ProcessingStrategy();
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    Queue queue = mock(Queue.class);
    when(queue.getProcessingStrategy()).thenReturn(processingStrategy);
    when(queue.getSubmitStrategy()).thenReturn(submitStrategy);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(42);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act
    queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue);

    // Assert that nothing has changed
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getProcessingStrategy();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with
   * {@code TenantId}, {@code Queue}.
   * <p>
   * Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  public void testValidateDataImplWithTenantIdQueue2() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);
    Queue queue = mock(Queue.class);
    when(queue.getProcessingStrategy()).thenThrow(new DataValidationException("An error occurred"));
    when(queue.getSubmitStrategy()).thenReturn(submitStrategy);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(42);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
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
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with
   * {@code TenantId}, {@code Queue}.
   * <ul>
   *   <li>Given {@link ProcessingStrategy} {@link ProcessingStrategy#getType()}
   * return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  public void testValidateDataImplWithTenantIdQueue_givenProcessingStrategyGetTypeReturnNull() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    when(processingStrategy.getType()).thenReturn(null);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    Queue queue = mock(Queue.class);
    when(queue.getProcessingStrategy()).thenReturn(processingStrategy);
    when(queue.getSubmitStrategy()).thenReturn(submitStrategy);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(42);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(processingStrategy).getType();
    verify(processingStrategy).setFailurePercentage(eq(10.0d));
    verify(processingStrategy).setMaxPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setRetries(eq(1));
    verify(processingStrategy).setType(eq(ProcessingStrategyType.SKIP_ALL_FAILURES));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getProcessingStrategy();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with
   * {@code TenantId}, {@code Queue}.
   * <ul>
   *   <li>Then calls {@link SubmitStrategy#getBatchSize()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  public void testValidateDataImplWithTenantIdQueue_thenCallsGetBatchSize() {
    // Arrange
    SubmitStrategy submitStrategy = mock(SubmitStrategy.class);
    when(submitStrategy.getBatchSize()).thenReturn(3);
    when(submitStrategy.getType()).thenReturn(SubmitStrategyType.BATCH);
    doNothing().when(submitStrategy).setBatchSize(anyInt());
    doNothing().when(submitStrategy).setType(Mockito.<SubmitStrategyType>any());
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    when(processingStrategy.getRetries()).thenThrow(new DataValidationException("An error occurred"));
    when(processingStrategy.getType()).thenReturn(ProcessingStrategyType.SKIP_ALL_FAILURES);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    Queue queue = mock(Queue.class);
    when(queue.getProcessingStrategy()).thenReturn(processingStrategy);
    when(queue.getSubmitStrategy()).thenReturn(submitStrategy);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(42);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(processingStrategy).getRetries();
    verify(processingStrategy).getType();
    verify(processingStrategy).setFailurePercentage(eq(10.0d));
    verify(processingStrategy).setMaxPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setRetries(eq(1));
    verify(processingStrategy).setType(eq(ProcessingStrategyType.SKIP_ALL_FAILURES));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getProcessingStrategy();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
    verify(submitStrategy).getBatchSize();
    verify(submitStrategy, atLeast(1)).getType();
    verify(submitStrategy).setBatchSize(eq(3));
    verify(submitStrategy).setType(eq(SubmitStrategyType.BURST));
  }

  /**
   * Test {@link QueueValidator#validateDataImpl(TenantId, Queue)} with
   * {@code TenantId}, {@code Queue}.
   * <ul>
   *   <li>Then calls {@link ProcessingStrategy#getRetries()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueValidator#validateDataImpl(TenantId, Queue)}
   */
  @Test
  public void testValidateDataImplWithTenantIdQueue_thenCallsGetRetries() {
    // Arrange
    SubmitStrategy submitStrategy = new SubmitStrategy();
    submitStrategy.setBatchSize(3);
    submitStrategy.setType(SubmitStrategyType.BURST);
    ProcessingStrategy processingStrategy = mock(ProcessingStrategy.class);
    when(processingStrategy.getRetries()).thenThrow(new DataValidationException("An error occurred"));
    when(processingStrategy.getType()).thenReturn(ProcessingStrategyType.SKIP_ALL_FAILURES);
    doNothing().when(processingStrategy).setFailurePercentage(anyDouble());
    doNothing().when(processingStrategy).setMaxPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setPauseBetweenRetries(anyLong());
    doNothing().when(processingStrategy).setRetries(anyInt());
    doNothing().when(processingStrategy).setType(Mockito.<ProcessingStrategyType>any());
    processingStrategy.setFailurePercentage(10.0d);
    processingStrategy.setMaxPauseBetweenRetries(1L);
    processingStrategy.setPauseBetweenRetries(1L);
    processingStrategy.setRetries(1);
    processingStrategy.setType(ProcessingStrategyType.SKIP_ALL_FAILURES);
    Queue queue = mock(Queue.class);
    when(queue.getProcessingStrategy()).thenReturn(processingStrategy);
    when(queue.getSubmitStrategy()).thenReturn(submitStrategy);
    when(queue.getPackProcessingTimeout()).thenReturn(1L);
    when(queue.getPartitions()).thenReturn(1);
    when(queue.getPollInterval()).thenReturn(42);
    when(queue.getTopic()).thenReturn("Topic");
    when(queue.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queue));
    verify(processingStrategy).getRetries();
    verify(processingStrategy).getType();
    verify(processingStrategy).setFailurePercentage(eq(10.0d));
    verify(processingStrategy).setMaxPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setPauseBetweenRetries(eq(1L));
    verify(processingStrategy).setRetries(eq(1));
    verify(processingStrategy).setType(eq(ProcessingStrategyType.SKIP_ALL_FAILURES));
    verify(queue).getName();
    verify(queue).getPackProcessingTimeout();
    verify(queue).getPartitions();
    verify(queue).getPollInterval();
    verify(queue).getProcessingStrategy();
    verify(queue).getSubmitStrategy();
    verify(queue).getTopic();
  }
}
