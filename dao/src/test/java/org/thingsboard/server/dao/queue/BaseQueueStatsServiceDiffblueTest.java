package org.thingsboard.server.dao.queue;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.QueueStats;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.service.validator.QueueStatsDataValidator;
import org.thingsboard.server.dao.sql.queue.JpaQueueStatsDao;

@ContextConfiguration(classes = {BaseQueueStatsService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseQueueStatsServiceDiffblueTest {
  @Autowired
  private BaseQueueStatsService baseQueueStatsService;

  @MockBean
  private DataValidator<QueueStats> dataValidator;

  @MockBean
  private QueueStatsDao queueStatsDao;

  /**
   * Test {@link BaseQueueStatsService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link QueueStatsDao#deleteByTenantId(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueStatsService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseQueueStatsService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(queueStatsDao).deleteByTenantId(Mockito.<TenantId>any());

    // Act
    baseQueueStatsService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(queueStatsDao).deleteByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link BaseQueueStatsService#getEntityType()}.
   * <p>
   * Method under test: {@link BaseQueueStatsService#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType BaseQueueStatsService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    JpaQueueStatsDao queueStatsDao = new JpaQueueStatsDao();

    // Act and Assert
    assertEquals(EntityType.QUEUE_STATS,
        (new BaseQueueStatsService(queueStatsDao, new QueueStatsDataValidator())).getEntityType());
  }
}
