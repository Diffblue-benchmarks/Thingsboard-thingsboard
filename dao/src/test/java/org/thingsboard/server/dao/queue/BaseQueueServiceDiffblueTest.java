package org.thingsboard.server.dao.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.UUID;
import org.hibernate.exception.ConstraintViolationException;
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
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseQueueService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseQueueServiceDiffblueTest {
  @Autowired
  private BaseQueueService baseQueueService;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DataValidator<Queue> dataValidator;

  @MockBean
  private QueueDao queueDao;

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseQueueService.deleteQueue(TenantId, QueueId)"})
  public void testDeleteQueue_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(queueDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    QueueId queueId = mock(QueueId.class);
    when(queueId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    baseQueueService.deleteQueue(ModelConstants.SYSTEM_TENANT, queueId);

    // Assert
    verify(queueId).getId();
    verify(queueDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   * <ul>
   *   <li>Then calls {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseQueueService.deleteQueue(TenantId, QueueId)"})
  public void testDeleteQueue_thenCallsHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(queueDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    baseQueueService.deleteQueue(ModelConstants.SYSTEM_TENANT,
        new QueueId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(queueDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseQueueService.deleteQueue(TenantId, QueueId)"})
  public void testDeleteQueue_thenThrowConstraintViolationException() {
    // Arrange
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing deleteQueue, queueId: [{}]")).when(queueDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseQueueService.deleteQueue(ModelConstants.SYSTEM_TENANT,
        new QueueId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(queueDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls {@link QueueDao#findQueuesByTenantId(TenantId, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseQueueService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsFindQueuesByTenantId() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseQueueService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(queueDao).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseQueueService#getEntityType()}.
   * <p>
   * Method under test: {@link BaseQueueService#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType BaseQueueService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.QUEUE, (new BaseQueueService()).getEntityType());
  }
}
