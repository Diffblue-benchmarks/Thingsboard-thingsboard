package org.thingsboard.server.dao.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseQueueService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseQueueServiceDiffblueTest {
  @Autowired private BaseQueueService baseQueueService;

  @MockBean private CleanUpService cleanUpService;

  @MockBean private DataValidator<Queue> dataValidator;

  @MockBean private QueueDao queueDao;

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   *
   * <p>Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseQueueService.deleteQueue(TenantId, QueueId)"})
  public void testDeleteQueue() {
    // Arrange
    doThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing deleteQueue, queueId: [{}]"))
        .when(queueDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseQueueService.deleteQueue(
                ModelConstants.SYSTEM_TENANT,
                new QueueId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(queueDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   *
   * <p>Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseQueueService.deleteQueue(TenantId, QueueId)"})
  public void testDeleteQueue2() {
    // Arrange
    doThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing deleteQueue, queueId: [{}]"))
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(queueDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseQueueService.deleteQueue(
                ModelConstants.SYSTEM_TENANT,
                new QueueId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(queueDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   *
   * <ul>
   *   <li>Given {@link BaseQueueService} (default constructor).
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseQueueService.deleteQueue(TenantId, QueueId)"})
  public void testDeleteQueue_givenBaseQueueService_thenThrowDataValidationException() {
    // Arrange
    BaseQueueService baseQueueService = new BaseQueueService();
    QueueId queueId = mock(QueueId.class);
    when(queueId.getId())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "fk_default_queue_device_profile"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseQueueService.deleteQueue(ModelConstants.SYSTEM_TENANT, queueId));
    verify(queueId).getId();
  }

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   *
   * <ul>
   *   <li>Given {@link CleanUpService} {@link
   *       CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseQueueService.deleteQueue(TenantId, QueueId)"})
  public void testDeleteQueue_givenCleanUpServiceHandleEntityDeletionEventDoesNothing() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(queueDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    baseQueueService.deleteQueue(
        ModelConstants.SYSTEM_TENANT,
        new QueueId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(queueDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseQueueService.deleteQueue(TenantId, QueueId)"})
  public void testDeleteQueue_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
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
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId)} with {@code tenantId}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BaseQueueService.findQueuesByTenantId(TenantId)"})
  public void testFindQueuesByTenantIdWithTenantId_thenThrowConstraintViolationException() {
    // Arrange
    when(queueDao.findAllByTenantId(Mockito.<TenantId>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing findQueues, tenantId: [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseQueueService.findQueuesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(queueDao).findAllByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId)} with {@code tenantId}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BaseQueueService.findQueuesByTenantId(TenantId)"})
  public void testFindQueuesByTenantIdWithTenantId_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(queueDao.findAllByTenantId(Mockito.<TenantId>any())).thenReturn(new ArrayList<>());

    // Act
    List<Queue> actualFindQueuesByTenantIdResult =
        baseQueueService.findQueuesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(queueDao).findAllByTenantId(isA(TenantId.class));
    assertTrue(actualFindQueuesByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link BaseQueueService#findAllQueues()}.
   *
   * <ul>
   *   <li>Given {@link QueueDao} {@link QueueDao#findAllQueues()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findAllQueues()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BaseQueueService.findAllQueues()"})
  public void testFindAllQueues_givenQueueDaoFindAllQueuesReturnArrayList_thenReturnEmpty() {
    // Arrange
    when(queueDao.findAllQueues()).thenReturn(new ArrayList<>());

    // Act
    List<Queue> actualFindAllQueuesResult = baseQueueService.findAllQueues();

    // Assert
    verify(queueDao).findAllQueues();
    assertTrue(actualFindAllQueuesResult.isEmpty());
  }

  /**
   * Test {@link BaseQueueService#findAllQueues()}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findAllQueues()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List BaseQueueService.findAllQueues()"})
  public void testFindAllQueues_thenThrowConstraintViolationException() {
    // Arrange
    when(queueDao.findAllQueues())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing findAllQueues"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseQueueService.findAllQueues());
    verify(queueDao).findAllQueues();
  }

  /**
   * Test {@link BaseQueueService#findQueueById(TenantId, QueueId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   *   <li>Then calls {@link QueueId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueueById(TenantId, QueueId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Queue BaseQueueService.findQueueById(TenantId, QueueId)"})
  public void testFindQueueById_givenFromString784f394c42b6435a983cB7beff2784f9_thenCallsGetId() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queue);
    QueueId queueId = mock(QueueId.class);
    when(queueId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Queue actualFindQueueByIdResult =
        baseQueueService.findQueueById(ModelConstants.SYSTEM_TENANT, queueId);

    // Assert
    verify(queueId).getId();
    verify(queueDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(queue, actualFindQueueByIdResult);
  }

  /**
   * Test {@link BaseQueueService#findQueueById(TenantId, QueueId)}.
   *
   * <ul>
   *   <li>Given {@link QueueDao} {@link QueueDao#findById(TenantId, UUID)} return {@link
   *       Queue#Queue()}.
   *   <li>Then return {@link Queue#Queue()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueueById(TenantId, QueueId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Queue BaseQueueService.findQueueById(TenantId, QueueId)"})
  public void testFindQueueById_givenQueueDaoFindByIdReturnQueue_thenReturnQueue() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queue);

    // Act
    Queue actualFindQueueByIdResult =
        baseQueueService.findQueueById(
            ModelConstants.SYSTEM_TENANT,
            new QueueId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(queueDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(queue, actualFindQueueByIdResult);
  }

  /**
   * Test {@link BaseQueueService#findQueueById(TenantId, QueueId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueueById(TenantId, QueueId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Queue BaseQueueService.findQueueById(TenantId, QueueId)"})
  public void testFindQueueById_thenThrowConstraintViolationException() {
    // Arrange
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing findQueueById, queueId: [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseQueueService.findQueueById(
                ModelConstants.SYSTEM_TENANT,
                new QueueId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(queueDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Queue BaseQueueService.findQueueByTenantIdAndName(TenantId, String)"})
  public void testFindQueueByTenantIdAndName_thenThrowConstraintViolationException() {
    // Arrange
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findQueueByTenantIdAndName, tenantId: [{}] queueName: [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseQueueService.findQueueByTenantIdAndName(
                ModelConstants.SYSTEM_TENANT, "Queue Name"));
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), eq("Queue Name"));
  }

  /**
   * Test {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link Queue#Queue()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Queue BaseQueueService.findQueueByTenantIdAndName(TenantId, String)"})
  public void testFindQueueByTenantIdAndName_whenSystem_tenant_thenReturnQueue() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(queue);

    // Act
    Queue actualFindQueueByTenantIdAndNameResult =
        baseQueueService.findQueueByTenantIdAndName(ModelConstants.SYSTEM_TENANT, "Queue Name");

    // Assert
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), eq("Queue Name"));
    assertSame(queue, actualFindQueueByTenantIdAndNameResult);
  }

  /**
   * Test {@link BaseQueueService#findQueueByTenantIdAndNameInternal(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@link Queue#Queue()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueueByTenantIdAndNameInternal(TenantId,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Queue BaseQueueService.findQueueByTenantIdAndNameInternal(TenantId, String)"})
  public void testFindQueueByTenantIdAndNameInternal_thenReturnQueue() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(queue);

    // Act
    Queue actualFindQueueByTenantIdAndNameInternalResult =
        baseQueueService.findQueueByTenantIdAndNameInternal(
            ModelConstants.SYSTEM_TENANT, "Queue Name");

    // Assert
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), eq("Queue Name"));
    assertSame(queue, actualFindQueueByTenantIdAndNameInternalResult);
  }

  /**
   * Test {@link BaseQueueService#findQueueByTenantIdAndNameInternal(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueueByTenantIdAndNameInternal(TenantId,
   * String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Queue BaseQueueService.findQueueByTenantIdAndNameInternal(TenantId, String)"})
  public void testFindQueueByTenantIdAndNameInternal_thenThrowConstraintViolationException() {
    // Arrange
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findQueueByTenantIdAndNameInternal, tenantId: [{}] queueName: [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseQueueService.findQueueByTenantIdAndNameInternal(
                ModelConstants.SYSTEM_TENANT, "Queue Name"));
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), eq("Queue Name"));
  }

  /**
   * Test {@link BaseQueueService#deleteQueuesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link QueueDao#findQueuesByTenantId(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#deleteQueuesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseQueueService.deleteQueuesByTenantId(TenantId)"})
  public void testDeleteQueuesByTenantId_thenCallsFindQueuesByTenantId() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseQueueService.deleteQueuesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(queueDao).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseQueueService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link QueueDao#findQueuesByTenantId(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#deleteByTenantId(TenantId)}
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
   * Test {@link BaseQueueService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   *   <li>Then calls {@link EntityId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional BaseQueueService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenFromString784f394c42b6435a983cB7beff2784f9_thenCallsGetId() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queue);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        baseQueueService.findEntity(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getId();
    verify(queueDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(queue, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseQueueService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional BaseQueueService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenThrowConstraintViolationException() {
    // Arrange
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing findQueueById, queueId: [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseQueueService.findEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(queueDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional BaseQueueService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queue);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        baseQueueService.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(queueDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(queue, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseQueueService#getEntityType()}.
   *
   * <p>Method under test: {@link BaseQueueService#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType BaseQueueService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.QUEUE, new BaseQueueService().getEntityType());
  }
}
