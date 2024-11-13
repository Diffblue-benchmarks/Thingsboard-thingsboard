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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.QueueStats;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {QueueStatsDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class QueueStatsDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @Autowired
  private QueueStatsDataValidator queueStatsDataValidator;

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   * with {@code TenantId}, {@code QueueStats}.
   * <p>
   * Method under test:
   * {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  public void testValidateDataImplWithTenantIdQueueStats() {
    // Arrange
    QueueStats queueStats = mock(QueueStats.class);
    when(queueStats.getServiceId()).thenThrow(new DataValidationException("An error occurred"));
    when(queueStats.getQueueName()).thenReturn("Queue Name");
    when(queueStats.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queueStats));
    verify(queueStats).getQueueName();
    verify(queueStats).getServiceId();
    verify(queueStats).getTenantId();
  }

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   * with {@code TenantId}, {@code QueueStats}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  public void testValidateDataImplWithTenantIdQueueStats_given42() {
    // Arrange
    QueueStats queueStats = mock(QueueStats.class);
    when(queueStats.getServiceId()).thenReturn("42");
    when(queueStats.getQueueName()).thenReturn("Queue Name");
    when(queueStats.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queueStats);

    // Assert that nothing has changed
    verify(queueStats).getQueueName();
    verify(queueStats).getServiceId();
    verify(queueStats).getTenantId();
  }

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   * with {@code TenantId}, {@code QueueStats}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  public void testValidateDataImplWithTenantIdQueueStats_givenEmptyString() {
    // Arrange
    QueueStats queueStats = mock(QueueStats.class);
    when(queueStats.getServiceId()).thenReturn("");
    when(queueStats.getQueueName()).thenReturn("Queue Name");
    when(queueStats.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queueStats));
    verify(queueStats).getQueueName();
    verify(queueStats).getServiceId();
    verify(queueStats).getTenantId();
  }

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   * with {@code TenantId}, {@code QueueStats}.
   * <ul>
   *   <li>When {@link QueueStats#QueueStats()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  public void testValidateDataImplWithTenantIdQueueStats_whenQueueStats() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new QueueStats()));
  }

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   * with {@code TenantId}, {@code QueueStats}.
   * <ul>
   *   <li>When {@link QueueStats} {@link QueueStats#getQueueName()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  public void testValidateDataImplWithTenantIdQueueStats_whenQueueStatsGetQueueNameReturnNull() {
    // Arrange
    QueueStats queueStats = mock(QueueStats.class);
    when(queueStats.getQueueName()).thenReturn(null);
    when(queueStats.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queueStats));
    verify(queueStats).getQueueName();
    verify(queueStats).getTenantId();
  }

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   * with {@code TenantId}, {@code QueueStats}.
   * <ul>
   *   <li>When {@link QueueStats} {@link QueueStats#getServiceId()} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  public void testValidateDataImplWithTenantIdQueueStats_whenQueueStatsGetServiceIdReturnNull() {
    // Arrange
    QueueStats queueStats = mock(QueueStats.class);
    when(queueStats.getServiceId()).thenReturn(null);
    when(queueStats.getQueueName()).thenReturn("Queue Name");
    when(queueStats.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queueStats));
    verify(queueStats).getQueueName();
    verify(queueStats).getServiceId();
    verify(queueStats).getTenantId();
  }
}
