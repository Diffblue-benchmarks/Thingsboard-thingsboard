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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.QueueStats;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {QueueStatsDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class QueueStatsDataValidatorDiffblueTest {
  @Autowired
  private QueueStatsDataValidator queueStatsDataValidator;

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)} with {@code TenantId}, {@code QueueStats}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueueStatsDataValidator.validateDataImpl(TenantId, QueueStats)"})
  public void testValidateDataImplWithTenantIdQueueStats_givenEmptyString() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setTenantId(ModelConstants.SYSTEM_TENANT);
    queueStats.setQueueName("Queue Stats");
    queueStats.setServiceId("");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queueStats));
  }

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)} with {@code TenantId}, {@code QueueStats}.
   * <ul>
   *   <li>When {@link QueueStats#QueueStats()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueueStatsDataValidator.validateDataImpl(TenantId, QueueStats)"})
  public void testValidateDataImplWithTenantIdQueueStats_whenQueueStats() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, new QueueStats()));
  }

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)} with {@code TenantId}, {@code QueueStats}.
   * <ul>
   *   <li>When {@link QueueStats#QueueStats()} QueueName is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueueStatsDataValidator.validateDataImpl(TenantId, QueueStats)"})
  public void testValidateDataImplWithTenantIdQueueStats_whenQueueStatsQueueNameIsNull() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setTenantId(ModelConstants.SYSTEM_TENANT);
    queueStats.setQueueName(null);
    queueStats.setServiceId("");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queueStats));
  }

  /**
   * Test {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)} with {@code TenantId}, {@code QueueStats}.
   * <ul>
   *   <li>When {@link QueueStats#QueueStats()} ServiceId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link QueueStatsDataValidator#validateDataImpl(TenantId, QueueStats)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void QueueStatsDataValidator.validateDataImpl(TenantId, QueueStats)"})
  public void testValidateDataImplWithTenantIdQueueStats_whenQueueStatsServiceIdIsNull() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    queueStats.setTenantId(ModelConstants.SYSTEM_TENANT);
    queueStats.setQueueName("Queue Stats");
    queueStats.setServiceId(null);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> queueStatsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, queueStats));
  }
}
