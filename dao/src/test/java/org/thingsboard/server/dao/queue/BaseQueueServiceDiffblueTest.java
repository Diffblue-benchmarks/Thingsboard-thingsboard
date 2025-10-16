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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
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
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.QueueId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.service.TenantProfileServiceTest;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;

@ContextConfiguration(classes = {BaseQueueService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseQueueServiceDiffblueTest {
  @Autowired private BaseQueueService baseQueueService;

  @MockBean private CleanUpService cleanUpService;

  @MockBean private DataValidator<Queue> dataValidator;

  @MockBean private QueueDao queueDao;

  @MockBean private TbTenantProfileCache tbTenantProfileCache;

  /**
   * Test {@link BaseQueueService#saveQueue(Queue)}.
   *
   * <p>Method under test: {@link BaseQueueService#saveQueue(Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue BaseQueueService.saveQueue(Queue)"})
  public void testSaveQueue() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing createOrUpdateQueue [{}]");
    when(queueDao.save(Mockito.<TenantId>any(), Mockito.<Queue>any()))
        .thenThrow(constraintViolationException);
    when(dataValidator.validate(Mockito.<Queue>any(), Mockito.<Function<Queue, TenantId>>any()))
        .thenReturn(new Queue());

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseQueueService.saveQueue(new Queue()));
    verify(queueDao).save(isNull(), isA(Queue.class));
    verify(dataValidator).validate(isA(Queue.class), isA(Function.class));
  }

  /**
   * Test {@link BaseQueueService#saveQueue(Queue)}.
   *
   * <ul>
   *   <li>Given {@link QueueDao} {@link QueueDao#save(TenantId, Object)} return {@link
   *       Queue#Queue()}.
   *   <li>When {@link Queue#Queue()}.
   *   <li>Then return {@link Queue#Queue()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#saveQueue(Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue BaseQueueService.saveQueue(Queue)"})
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
   *
   * <ul>
   *   <li>Given {@link QueueDao}.
   *   <li>When {@link Queue#Queue()}.
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#saveQueue(Queue)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue BaseQueueService.saveQueue(Queue)"})
  public void testSaveQueue_givenQueueDao_whenQueue_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing createOrUpdateQueue [{}]");
    when(dataValidator.validate(Mockito.<Queue>any(), Mockito.<Function<Queue, TenantId>>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseQueueService.saveQueue(new Queue()));
    verify(dataValidator).validate(isA(Queue.class), isA(Function.class));
  }

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   *
   * <p>Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseQueueService.deleteQueue(TenantId, QueueId)"})
  public void testDeleteQueue() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteQueue, queueId: [{}]");
    doThrow(constraintViolationException)
        .when(queueDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseQueueService.deleteQueue(
                ModelConstants.SYSTEM_TENANT, new QueueId(ModelConstants.NULL_UUID)));
    verify(queueDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   *
   * <p>Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseQueueService.deleteQueue(TenantId, QueueId)"})
  public void testDeleteQueue2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), null);
    doThrow(constraintViolationException)
        .when(queueDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseQueueService.deleteQueue(
                ModelConstants.SYSTEM_TENANT, new QueueId(ModelConstants.NULL_UUID)));
    verify(queueDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   *
   * <p>Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseQueueService.deleteQueue(TenantId, QueueId)"})
  public void testDeleteQueue3() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteQueue, queueId: [{}]");
    doThrow(constraintViolationException)
        .when(cleanUpService)
        .handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(queueDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseQueueService.deleteQueue(
                ModelConstants.SYSTEM_TENANT, new QueueId(ModelConstants.NULL_UUID)));
    verify(queueDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseQueueService.deleteQueue(TenantId, QueueId)"})
  public void testDeleteQueue_givenCleanUpServiceHandleEntityDeletionEventDoesNothing() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    doNothing().when(queueDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    baseQueueService.deleteQueue(
        ModelConstants.SYSTEM_TENANT, new QueueId(ModelConstants.NULL_UUID));

    // Assert
    verify(queueDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
  }

  /**
   * Test {@link BaseQueueService#deleteQueue(TenantId, QueueId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link QueueId} {@link QueueId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link QueueId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseQueueService.deleteQueue(TenantId, QueueId)"})
  public void testDeleteQueue_givenNull_uuid_whenQueueIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
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
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#deleteQueue(TenantId, QueueId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseQueueService.deleteQueue(TenantId, QueueId)"})
  public void testDeleteQueue_thenThrowDataValidationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "fk_default_queue_device_profile");
    doThrow(constraintViolationException)
        .when(queueDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseQueueService.deleteQueue(
                ModelConstants.SYSTEM_TENANT, new QueueId(ModelConstants.NULL_UUID)));
    verify(queueDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId)} with {@code tenantId}.
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseQueueService.findQueuesByTenantId(TenantId)"})
  public void testFindQueuesByTenantIdWithTenantId() {
    // Arrange
    when(queueDao.findAllByTenantId(Mockito.<TenantId>any())).thenReturn(new ArrayList<>());
    when(tbTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act
    List<Queue> actualFindQueuesByTenantIdResult =
        baseQueueService.findQueuesByTenantId(mock(TenantId.class));

    // Assert
    verify(queueDao).findAllByTenantId(isA(TenantId.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertTrue(actualFindQueuesByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with {@code tenantId},
   * {@code pageLink}.
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseQueueService.findQueuesByTenantId(TenantId, PageLink)"})
  public void testFindQueuesByTenantIdWithTenantIdPageLink() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findQueues pageLink [{}]");
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseQueueService.findQueuesByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(queueDao).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with {@code tenantId},
   * {@code pageLink}.
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseQueueService.findQueuesByTenantId(TenantId, PageLink)"})
  public void testFindQueuesByTenantIdWithTenantIdPageLink2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findQueues pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseQueueService.findQueuesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with {@code tenantId},
   * {@code pageLink}.
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseQueueService.findQueuesByTenantId(TenantId, PageLink)"})
  public void testFindQueuesByTenantIdWithTenantIdPageLink3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(pageLink.getPage()).thenThrow(constraintViolationException);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseQueueService.findQueuesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with {@code tenantId},
   * {@code pageLink}.
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseQueueService.findQueuesByTenantId(TenantId, PageLink)"})
  public void testFindQueuesByTenantIdWithTenantIdPageLink4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findQueues pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseQueueService.findQueuesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with {@code tenantId},
   * {@code pageLink}.
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseQueueService.findQueuesByTenantId(TenantId, PageLink)"})
  public void testFindQueuesByTenantIdWithTenantIdPageLink5() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));
    TenantId tenantId = mock(TenantId.class);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult =
        baseQueueService.findQueuesByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(queueDao).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindQueuesByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with {@code tenantId},
   * {@code pageLink}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseQueueService.findQueuesByTenantId(TenantId, PageLink)"})
  public void testFindQueuesByTenantIdWithTenantIdPageLink_givenBy_created_time_desc() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult =
        baseQueueService.findQueuesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(queueDao).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindQueuesByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with {@code tenantId},
   * {@code pageLink}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseQueueService.findQueuesByTenantId(TenantId, PageLink)"})
  public void testFindQueuesByTenantIdWithTenantIdPageLink_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult =
        baseQueueService.findQueuesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(queueDao).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindQueuesByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with {@code tenantId},
   * {@code pageLink}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseQueueService.findQueuesByTenantId(TenantId, PageLink)"})
  public void testFindQueuesByTenantIdWithTenantIdPageLink_thenCallsGetProperty() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult =
        baseQueueService.findQueuesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(queueDao).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindQueuesByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with {@code tenantId},
   * {@code pageLink}.
   *
   * <ul>
   *   <li>Then calls {@link TenantProfile#isIsolatedTbRuleEngine()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseQueueService.findQueuesByTenantId(TenantId, PageLink)"})
  public void testFindQueuesByTenantIdWithTenantIdPageLink_thenCallsIsIsolatedTbRuleEngine() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);
    TenantId tenantId = mock(TenantId.class);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult =
        baseQueueService.findQueuesByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantProfile).isIsolatedTbRuleEngine();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(queueDao).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindQueuesByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with {@code tenantId},
   * {@code pageLink}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseQueueService.findQueuesByTenantId(TenantId, PageLink)"})
  public void testFindQueuesByTenantIdWithTenantIdPageLink_whenFirst_page() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult =
        baseQueueService.findQueuesByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(queueDao).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindQueuesByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)} with {@code tenantId},
   * {@code pageLink}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseQueueService.findQueuesByTenantId(TenantId, PageLink)"})
  public void testFindQueuesByTenantIdWithTenantIdPageLink_whenTenantIdWithIdIsNull_uuid() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantId tenantId = new TenantId(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Queue> actualFindQueuesByTenantIdResult =
        baseQueueService.findQueuesByTenantId(tenantId, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(queueDao).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindQueuesByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId)} with {@code tenantId}.
   *
   * <ul>
   *   <li>Then calls {@link TenantProfile#isIsolatedTbRuleEngine()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseQueueService.findQueuesByTenantId(TenantId)"})
  public void testFindQueuesByTenantIdWithTenantId_thenCallsIsIsolatedTbRuleEngine() {
    // Arrange
    when(queueDao.findAllByTenantId(Mockito.<TenantId>any())).thenReturn(new ArrayList<>());

    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);

    // Act
    List<Queue> actualFindQueuesByTenantIdResult =
        baseQueueService.findQueuesByTenantId(mock(TenantId.class));

    // Assert
    verify(tenantProfile).isIsolatedTbRuleEngine();
    verify(queueDao).findAllByTenantId(isA(TenantId.class));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertTrue(actualFindQueuesByTenantIdResult.isEmpty());
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseQueueService.findQueuesByTenantId(TenantId)"})
  public void testFindQueuesByTenantIdWithTenantId_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findQueues, tenantId: [{}]");
    when(queueDao.findAllByTenantId(Mockito.<TenantId>any()))
        .thenThrow(constraintViolationException);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test {@link BaseQueueService#findQueuesByTenantId(TenantId)} with {@code tenantId}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueuesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseQueueService.findQueuesByTenantId(TenantId)"})
  public void testFindQueuesByTenantIdWithTenantId_whenTenantIdWithIdIsNull_uuid() {
    // Arrange
    when(queueDao.findAllByTenantId(Mockito.<TenantId>any())).thenReturn(new ArrayList<>());

    // Act
    List<Queue> actualFindQueuesByTenantIdResult =
        baseQueueService.findQueuesByTenantId(new TenantId(ModelConstants.NULL_UUID));

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseQueueService.findAllQueues()"})
  public void testFindAllQueues_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findAllQueues");
    when(queueDao.findAllQueues()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseQueueService.findAllQueues());
    verify(queueDao).findAllQueues();
  }

  /**
   * Test {@link BaseQueueService#findQueueById(TenantId, QueueId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link QueueId} {@link QueueId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link QueueId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueueById(TenantId, QueueId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue BaseQueueService.findQueueById(TenantId, QueueId)"})
  public void testFindQueueById_givenNull_uuid_whenQueueIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findQueueById, queueId: [{}]");
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(constraintViolationException);

    QueueId queueId = mock(QueueId.class);
    when(queueId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseQueueService.findQueueById(ModelConstants.SYSTEM_TENANT, queueId));
    verify(queueId).getId();
    verify(queueDao).findById(isA(TenantId.class), isA(UUID.class));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue BaseQueueService.findQueueById(TenantId, QueueId)"})
  public void testFindQueueById_givenQueueDaoFindByIdReturnQueue_thenReturnQueue() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queue);

    // Act
    Queue actualFindQueueByIdResult =
        baseQueueService.findQueueById(
            ModelConstants.SYSTEM_TENANT, new QueueId(ModelConstants.NULL_UUID));

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue BaseQueueService.findQueueById(TenantId, QueueId)"})
  public void testFindQueueById_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findQueueById, queueId: [{}]");
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseQueueService.findQueueById(
                ModelConstants.SYSTEM_TENANT, new QueueId(ModelConstants.NULL_UUID)));
    verify(queueDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}.
   *
   * <p>Method under test: {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue BaseQueueService.findQueueByTenantIdAndName(TenantId, String)"})
  public void testFindQueueByTenantIdAndName() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(queue);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any()))
        .thenReturn(TenantProfileServiceTest.createTenantProfile("Name"));

    // Act
    Queue actualFindQueueByTenantIdAndNameResult =
        baseQueueService.findQueueByTenantIdAndName(mock(TenantId.class), "Queue Name");

    // Assert
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), eq("Queue Name"));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertSame(queue, actualFindQueueByTenantIdAndNameResult);
  }

  /**
   * Test {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantProfile#isIsolatedTbRuleEngine()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue BaseQueueService.findQueueByTenantIdAndName(TenantId, String)"})
  public void testFindQueueByTenantIdAndName_thenCallsIsIsolatedTbRuleEngine() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(queue);

    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(tenantProfile);

    // Act
    Queue actualFindQueueByTenantIdAndNameResult =
        baseQueueService.findQueueByTenantIdAndName(mock(TenantId.class), "Queue Name");

    // Assert
    verify(tenantProfile).isIsolatedTbRuleEngine();
    verify(queueDao).findQueueByTenantIdAndName(isA(TenantId.class), eq("Queue Name"));
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertSame(queue, actualFindQueueByTenantIdAndNameResult);
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue BaseQueueService.findQueueByTenantIdAndName(TenantId, String)"})
  public void testFindQueueByTenantIdAndName_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findQueueByTenantIdAndName, tenantId: [{}] queueName: [{}]");
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(constraintViolationException);

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}.
   *
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@link Queue#Queue()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findQueueByTenantIdAndName(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue BaseQueueService.findQueueByTenantIdAndName(TenantId, String)"})
  public void testFindQueueByTenantIdAndName_whenTenantIdWithIdIsNull_uuid_thenReturnQueue() {
    // Arrange
    Queue queue = new Queue();
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(queue);

    // Act
    Queue actualFindQueueByTenantIdAndNameResult =
        baseQueueService.findQueueByTenantIdAndName(
            new TenantId(ModelConstants.NULL_UUID), "Queue Name");

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Queue BaseQueueService.findQueueByTenantIdAndNameInternal(TenantId, String)"})
  public void testFindQueueByTenantIdAndNameInternal_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findQueueByTenantIdAndNameInternal, tenantId: [{}] queueName: [{}]");
    when(queueDao.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(constraintViolationException);

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
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#deleteQueuesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseQueueService.deleteQueuesByTenantId(TenantId)"})
  public void testDeleteQueuesByTenantId_givenNull_uuid_whenTenantIdGetIdReturnNull_uuid() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    baseQueueService.deleteQueuesByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(queueDao).findQueuesByTenantId(isA(TenantId.class), isA(PageLink.class));
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test {@link BaseQueueService#deleteQueuesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#deleteQueuesByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseQueueService.deleteQueuesByTenantId(TenantId)"})
  public void testDeleteQueuesByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Incorrect tenant id for delete queues request.");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseQueueService.deleteQueuesByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseQueueService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseQueueService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<Queue> emptyPageDataResult = PageData.emptyPageData();
    when(queueDao.findQueuesByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    baseQueueService.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test {@link BaseQueueService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseQueueService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Incorrect tenant id for delete queues request.");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseQueueService.deleteByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseQueueService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link AlarmId} {@link AlarmId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseQueueService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenNull_uuid_whenAlarmIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findQueueById, queueId: [{}]");
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(constraintViolationException);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseQueueService.findEntity(ModelConstants.SYSTEM_TENANT, entityId));
    verify(entityId).getId();
    verify(queueDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link QueueDao} {@link QueueDao#findById(TenantId, UUID)} return {@link
   *       Queue#Queue()}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseQueueService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenQueueDaoFindByIdReturnQueue_thenReturnPresent() {
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
   * Test {@link BaseQueueService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseQueueService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findQueueById, queueId: [{}]");
    when(queueDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseQueueService.findEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(queueDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueService#getEntityType()}.
   *
   * <p>Method under test: {@link BaseQueueService#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType BaseQueueService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.QUEUE, new BaseQueueService().getEntityType());
  }
}
