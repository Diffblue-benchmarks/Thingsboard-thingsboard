package org.thingsboard.server.dao.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;

@ContextConfiguration(classes = {BaseQueueService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class BaseQueueServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  private BaseQueueService baseQueueService;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DataValidator<Queue> dataValidator;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private QueueDao queueDao;

  @MockBean
  private RelationService relationService;

  @MockBean
  private TbTenantProfileCache tbTenantProfileCache;

  /**
   * Test {@link BaseQueueService#saveQueue(Queue)}.
   * <ul>
   *   <li>Given {@link QueueDao} {@link Dao#save(TenantId, Object)} return
   * {@link Queue#Queue()}.</li>
   *   <li>When {@link Queue#Queue()}.</li>
   *   <li>Then return {@link Queue#Queue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#saveQueue(Queue)}
   */
  @Test
  public void testSaveQueue_givenQueueDaoSaveReturnQueue_whenQueue_thenReturnQueue() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.save(Mockito.<TenantId>any(), Mockito.<Queue>any())).thenReturn(queue);
    when(dataValidator.validate(Mockito.<Queue>any(), Mockito.<Function<Queue, TenantId>>any()))
        .thenReturn(new Queue());

    // Act
    Queue actualSaveQueueResult = baseQueueService.saveQueue(new Queue());

    // Assert
    verify(queueDao).save(isNull(), isA(Queue.class));
    verify(dataValidator).validate(isA(Queue.class), isA(Function.class));
    assertSame(queue, actualSaveQueueResult);
  }

  /**
   * Test {@link BaseQueueService#saveQueue(Queue)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#saveQueue(Queue)}
   */
  @Test
  public void testSaveQueue_thenThrowConstraintViolationException() {
    // Arrange
    when(dataValidator.validate(Mockito.<Queue>any(), Mockito.<Function<Queue, TenantId>>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
            "Executing createOrUpdateQueue [{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseQueueService.saveQueue(new Queue()));
    verify(dataValidator).validate(isA(Queue.class), isA(Function.class));
  }

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   * <p>
   * Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  public void testDeleteQueue() {
    // Arrange
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing deleteQueue, queueId: [{}]")).when(queueDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseQueueService.deleteQueue(ModelConstants.SYSTEM_TENANT, new QueueId(ModelConstants.NULL_UUID)));
    verify(queueDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   * <p>
   * Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  public void testDeleteQueue2() {
    // Arrange
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(), null)).when(queueDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseQueueService.deleteQueue(ModelConstants.SYSTEM_TENANT, new QueueId(ModelConstants.NULL_UUID)));
    verify(queueDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link QueueId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  public void testDeleteQueue_givenNull_uuid_whenQueueIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(queueDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    QueueId queueId = mock(QueueId.class);
    when(queueId.getId()).thenReturn(ModelConstants.NULL_UUID);

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
   *   <li>Then calls
   * {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  public void testDeleteQueue_thenCallsHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    doNothing().when(queueDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    baseQueueService.deleteQueue(ModelConstants.SYSTEM_TENANT, new QueueId(ModelConstants.NULL_UUID));

    // Assert
    verify(queueDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  public void testDeleteQueue_thenThrowDataValidationException() {
    // Arrange
    doThrow(
        new ConstraintViolationException("An error occurred", new SQLException(), "fk_default_queue_device_profile"))
        .when(queueDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseQueueService.deleteQueue(ModelConstants.SYSTEM_TENANT, new QueueId(ModelConstants.NULL_UUID)));
    verify(queueDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId)} with
   * {@code tenantId}.
   * <p>
   * Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId)}
   */
  @Test
  public void testFindQueuesByTenantIdWithTenantId() {
    // Arrange
    when(queueDao.findAllByTenantId(Mockito.<TenantId>any())).thenReturn(new ArrayList<>());
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    List<Queue> actualFindQueuesByTenantIdResult = baseQueueService.findQueuesByTenantId(tenantId);

    // Assert
    verify(queueDao).findAllByTenantId(isA(TenantId.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(actualFindQueuesByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId)} with
   * {@code tenantId}.
   * <p>
   * Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId)}
   */
  @Test
  public void testFindQueuesByTenantIdWithTenantId2() {
    // Arrange
    when(queueDao.findAllByTenantId(Mockito.<TenantId>any())).thenReturn(new ArrayList<>());
    TenantId tenantId = new TenantId(ModelConstants.NULL_UUID);

    // Act
    List<Queue> actualFindQueuesByTenantIdResult = baseQueueService.findQueuesByTenantId(tenantId);

    // Assert
    verify(queueDao).findAllByTenantId(isA(TenantId.class));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(actualFindQueuesByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId)} with
   * {@code tenantId}.
   * <p>
   * Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId)}
   */
  @Test
  public void testFindQueuesByTenantIdWithTenantId3() {
    // Arrange
    when(queueDao.findAllByTenantId(Mockito.<TenantId>any())).thenReturn(new ArrayList<>());
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    // Act
    List<Queue> actualFindQueuesByTenantIdResult = baseQueueService
        .findQueuesByTenantId(new TenantId(UUID.randomUUID()));

    // Assert
    verify(queueDao).findAllByTenantId(isA(TenantId.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertTrue(actualFindQueuesByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with
   * {@code tenantId}, {@code pageLink}.
   * <p>
   * Method under test:
   * {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindQueuesByTenantIdWithTenantIdPageLink() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult = baseQueueService
        .findQueuesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(queueDao).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindQueuesByTenantIdResult.EMPTY_PAGE_DATA, actualFindQueuesByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with
   * {@code tenantId}, {@code pageLink}.
   * <p>
   * Method under test:
   * {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindQueuesByTenantIdWithTenantIdPageLink2() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult = baseQueueService
        .findQueuesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(queueDao).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindQueuesByTenantIdResult.EMPTY_PAGE_DATA, actualFindQueuesByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with
   * {@code tenantId}, {@code pageLink}.
   * <p>
   * Method under test:
   * {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindQueuesByTenantIdWithTenantIdPageLink3() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Executing findQueues pageLink [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseQueueService.findQueuesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with
   * {@code tenantId}, {@code pageLink}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindQueuesByTenantIdWithTenantIdPageLink_thenThrowDataValidationException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseQueueService.findQueuesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with
   * {@code tenantId}, {@code pageLink}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindQueuesByTenantIdWithTenantIdPageLink_whenFirst_page() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult = baseQueueService
        .findQueuesByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(queueDao).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindQueuesByTenantIdResult.EMPTY_PAGE_DATA, actualFindQueuesByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with
   * {@code tenantId}, {@code pageLink}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindQueuesByTenantIdWithTenantIdPageLink_whenTenantIdWithIdIsNull_uuid() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult = baseQueueService
        .findQueuesByTenantId(new TenantId(ModelConstants.NULL_UUID), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(queueDao).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindQueuesByTenantIdResult.EMPTY_PAGE_DATA, actualFindQueuesByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId)} with
   * {@code tenantId}.
   * <ul>
   *   <li>Then calls {@link TenantProfile#isIsolatedTbRuleEngine()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId)}
   */
  @Test
  public void testFindQueuesByTenantIdWithTenantId_thenCallsIsIsolatedTbRuleEngine() {
    // Arrange
    when(queueDao.findAllByTenantId(Mockito.<TenantId>any())).thenReturn(new ArrayList<>());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);

    // Act
    List<Queue> actualFindQueuesByTenantIdResult = baseQueueService
        .findQueuesByTenantId(new TenantId(UUID.randomUUID()));

    // Assert
    verify(tenantProfile).isIsolatedTbRuleEngine();
    verify(queueDao).findAllByTenantId(isA(TenantId.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertTrue(actualFindQueuesByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId)} with
   * {@code tenantId}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId)}
   */
  @Test
  public void testFindQueuesByTenantIdWithTenantId_thenThrowConstraintViolationException() {
    // Arrange
    when(queueDao.findAllByTenantId(Mockito.<TenantId>any())).thenThrow(new ConstraintViolationException(
        "An error occurred", new SQLException(), "Executing findQueues, tenantId: [{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseQueueService.findQueuesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(queueDao).findAllByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId)} with
   * {@code tenantId}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId)}
   */
  @Test
  public void testFindQueuesByTenantIdWithTenantId_whenTenantIdWithIdIsNull() {
    // Arrange
    when(queueDao.findAllByTenantId(Mockito.<TenantId>any())).thenReturn(new ArrayList<>());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);

    // Act
    List<Queue> actualFindQueuesByTenantIdResult = baseQueueService.findQueuesByTenantId(new TenantId(null));

    // Assert
    verify(tenantProfile).isIsolatedTbRuleEngine();
    verify(queueDao).findAllByTenantId(isA(TenantId.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertTrue(actualFindQueuesByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link BaseQueueService#findAllQueues()}.
   * <ul>
   *   <li>Given {@link QueueDao} {@link QueueDao#findAllQueues()} return
   * {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#findAllQueues()}
   */
  @Test
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
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#findAllQueues()}
   */
  @Test
  public void testFindAllQueues_thenThrowConstraintViolationException() {
    // Arrange
    when(queueDao.findAllQueues()).thenThrow(
        new ConstraintViolationException("An error occurred", new SQLException(), "Executing findAllQueues"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseQueueService.findAllQueues());
    verify(queueDao).findAllQueues();
  }

  /**
   * Test {@link BaseQueueService#findQueueById(TenantId, QueueId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link QueueId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#findQueueById(TenantId, QueueId)}
   */
  @Test
  public void testFindQueueById_givenNull_uuid_whenQueueIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queue);
    QueueId queueId = mock(QueueId.class);
    when(queueId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Queue actualFindQueueByIdResult = baseQueueService.findQueueById(ModelConstants.SYSTEM_TENANT, queueId);

    // Assert
    verify(queueId).getId();
    verify(queueDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(queue, actualFindQueueByIdResult);
  }

  /**
   * Test {@link BaseQueueService#findQueueById(TenantId, QueueId)}.
   * <ul>
   *   <li>When {@link QueueId#QueueId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link Queue#Queue()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#findQueueById(TenantId, QueueId)}
   */
  @Test
  public void testFindQueueById_whenQueueIdWithIdIsNull_uuid_thenReturnQueue() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queue);

    // Act
    Queue actualFindQueueByIdResult = baseQueueService.findQueueById(ModelConstants.SYSTEM_TENANT,
        new QueueId(ModelConstants.NULL_UUID));

    // Assert
    verify(queueDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(queue, actualFindQueueByIdResult);
  }

  /**
   * Test {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}.
   * <p>
   * Method under test:
   * {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}
   */
  @Test
  public void testFindQueueByTenantIdAndName() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(queue);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    Queue actualFindQueueByTenantIdAndNameResult = baseQueueService.findQueueByTenantIdAndName(tenantId, "Queue Name");

    // Assert
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), eq("Queue Name"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertSame(queue, actualFindQueueByTenantIdAndNameResult);
  }

  /**
   * Test {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}.
   * <p>
   * Method under test:
   * {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}
   */
  @Test
  public void testFindQueueByTenantIdAndName2() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(queue);
    TenantId tenantId = new TenantId(ModelConstants.NULL_UUID);

    // Act
    Queue actualFindQueueByTenantIdAndNameResult = baseQueueService.findQueueByTenantIdAndName(tenantId, "Queue Name");

    // Assert
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), eq("Queue Name"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertSame(queue, actualFindQueueByTenantIdAndNameResult);
  }

  /**
   * Test {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}.
   * <ul>
   *   <li>Given {@link TbTenantProfileCache}
   * {@link TbTenantProfileCache#get(TenantId)} return
   * {@link TenantProfile#TenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}
   */
  @Test
  public void testFindQueueByTenantIdAndName_givenTbTenantProfileCacheGetReturnTenantProfile() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(queue);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    // Act
    Queue actualFindQueueByTenantIdAndNameResult = baseQueueService
        .findQueueByTenantIdAndName(new TenantId(UUID.randomUUID()), "Queue Name");

    // Assert
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), eq("Queue Name"));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertSame(queue, actualFindQueueByTenantIdAndNameResult);
  }

  /**
   * Test {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}.
   * <ul>
   *   <li>Then calls {@link TenantProfile#isIsolatedTbRuleEngine()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}
   */
  @Test
  public void testFindQueueByTenantIdAndName_thenCallsIsIsolatedTbRuleEngine() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(queue);
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);

    // Act
    Queue actualFindQueueByTenantIdAndNameResult = baseQueueService
        .findQueueByTenantIdAndName(new TenantId(UUID.randomUUID()), "Queue Name");

    // Assert
    verify(tenantProfile).isIsolatedTbRuleEngine();
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), eq("Queue Name"));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertSame(queue, actualFindQueueByTenantIdAndNameResult);
  }

  /**
   * Test {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}
   */
  @Test
  public void testFindQueueByTenantIdAndName_thenThrowConstraintViolationException() {
    // Arrange
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
            "Executing findQueueByTenantIdAndName, tenantId: [{}] queueName: [{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseQueueService.findQueueByTenantIdAndName(ModelConstants.SYSTEM_TENANT, "Queue Name"));
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), eq("Queue Name"));
  }

  /**
   * Test {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}
   */
  @Test
  public void testFindQueueByTenantIdAndName_whenTenantIdWithIdIsNull() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(queue);
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);

    // Act
    Queue actualFindQueueByTenantIdAndNameResult = baseQueueService.findQueueByTenantIdAndName(new TenantId(null),
        "Queue Name");

    // Assert
    verify(tenantProfile).isIsolatedTbRuleEngine();
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), eq("Queue Name"));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertSame(queue, actualFindQueueByTenantIdAndNameResult);
  }

  /**
   * Test
   * {@link BaseQueueService#findQueueByTenantIdAndNameInternal(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link Queue#Queue()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueService#findQueueByTenantIdAndNameInternal(TenantId, String)}
   */
  @Test
  public void testFindQueueByTenantIdAndNameInternal_thenReturnQueue() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(queue);

    // Act
    Queue actualFindQueueByTenantIdAndNameInternalResult = baseQueueService
        .findQueueByTenantIdAndNameInternal(ModelConstants.SYSTEM_TENANT, "Queue Name");

    // Assert
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), eq("Queue Name"));
    assertSame(queue, actualFindQueueByTenantIdAndNameInternalResult);
  }

  /**
   * Test
   * {@link BaseQueueService#findQueueByTenantIdAndNameInternal(TenantId, String)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueService#findQueueByTenantIdAndNameInternal(TenantId, String)}
   */
  @Test
  public void testFindQueueByTenantIdAndNameInternal_thenThrowConstraintViolationException() {
    // Arrange
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(),
            "Executing findQueueByTenantIdAndNameInternal, tenantId: [{}] queueName: [{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseQueueService.findQueueByTenantIdAndNameInternal(ModelConstants.SYSTEM_TENANT, "Queue Name"));
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), eq("Queue Name"));
  }

  /**
   * Test {@link BaseQueueService#deleteQueuesByTenantId(TenantId)}.
   * <ul>
   *   <li>Then calls
   * {@link QueueDao#findQueuesByTenantId(TenantId, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#deleteQueuesByTenantId(TenantId)}
   */
  @Test
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
   * <ul>
   *   <li>Then calls
   * {@link QueueDao#findQueuesByTenantId(TenantId, PageLink)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#deleteByTenantId(TenantId)}
   */
  @Test
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
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link EntityId} {@link EntityId#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queue);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult = baseQueueService.findEntity(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getId();
    verify(queueDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(queue, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseQueueService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseQueueService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queue);

    // Act
    Optional<HasId<?>> actualFindEntityResult = baseQueueService.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(queueDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(queue, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseQueueService#getEntityType()}.
   * <p>
   * Method under test: {@link BaseQueueService#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.QUEUE, (new BaseQueueService()).getEntityType());
  }
}
