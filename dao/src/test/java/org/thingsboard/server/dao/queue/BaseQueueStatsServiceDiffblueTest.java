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
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
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
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.QueueStatsId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.queue.QueueStats;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.service.validator.QueueStatsDataValidator;
import org.thingsboard.server.dao.sql.queue.JpaQueueStatsDao;

@ContextConfiguration(classes = {BaseQueueStatsService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseQueueStatsServiceDiffblueTest {
  @Autowired private BaseQueueStatsService baseQueueStatsService;

  @MockBean private DataValidator<QueueStats> dataValidator;

  @MockBean private QueueStatsDao queueStatsDao;

  /**
   * Test {@link BaseQueueStatsService#save(TenantId, QueueStats)}.
   *
   * <p>Method under test: {@link BaseQueueStatsService#save(TenantId, QueueStats)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"QueueStats BaseQueueStatsService.save(TenantId, QueueStats)"})
  public void testSave() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    when(queueStatsDao.save(Mockito.<TenantId>any(), Mockito.<QueueStats>any()))
        .thenReturn(queueStats);
    when(dataValidator.validate(
            Mockito.<QueueStats>any(), Mockito.<Function<QueueStats, TenantId>>any()))
        .thenReturn(new QueueStats());

    // Act
    QueueStats actualSaveResult =
        baseQueueStatsService.save(ModelConstants.SYSTEM_TENANT, new QueueStats());

    // Assert
    verify(queueStatsDao).save(isA(TenantId.class), isA(QueueStats.class));
    verify(dataValidator).validate(isA(QueueStats.class), isA(Function.class));
    assertSame(queueStats, actualSaveResult);
  }

  /**
   * Test {@link BaseQueueStatsService#findQueueStatsById(TenantId, QueueStatsId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link QueueStatsId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueStatsService#findQueueStatsById(TenantId, QueueStatsId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"QueueStats BaseQueueStatsService.findQueueStatsById(TenantId, QueueStatsId)"})
  public void testFindQueueStatsById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    when(queueStatsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(queueStats);

    QueueStatsId queueStatsId = mock(QueueStatsId.class);
    when(queueStatsId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    QueueStats actualFindQueueStatsByIdResult =
        baseQueueStatsService.findQueueStatsById(ModelConstants.SYSTEM_TENANT, queueStatsId);

    // Assert
    verify(queueStatsId, atLeast(1)).getId();
    verify(queueStatsDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(queueStats, actualFindQueueStatsByIdResult);
  }

  /**
   * Test {@link BaseQueueStatsService#findQueueStatsById(TenantId, QueueStatsId)}.
   *
   * <ul>
   *   <li>When {@link QueueStatsId#QueueStatsId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@link QueueStats#QueueStats()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueStatsService#findQueueStatsById(TenantId, QueueStatsId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"QueueStats BaseQueueStatsService.findQueueStatsById(TenantId, QueueStatsId)"})
  public void testFindQueueStatsById_whenQueueStatsIdWithIdIsNull_uuid_thenReturnQueueStats() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    when(queueStatsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(queueStats);

    // Act
    QueueStats actualFindQueueStatsByIdResult =
        baseQueueStatsService.findQueueStatsById(
            ModelConstants.SYSTEM_TENANT, new QueueStatsId(ModelConstants.NULL_UUID));

    // Assert
    verify(queueStatsDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(queueStats, actualFindQueueStatsByIdResult);
  }

  /**
   * Test {@link BaseQueueStatsService#findQueueStatsByIds(TenantId, List)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueStatsService#findQueueStatsByIds(TenantId, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseQueueStatsService.findQueueStatsByIds(TenantId, List)"})
  public void testFindQueueStatsByIds_thenReturnEmpty() {
    // Arrange
    when(queueStatsDao.findByIds(Mockito.<TenantId>any(), Mockito.<List<QueueStatsId>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<QueueStatsId> queueStatsIds = new ArrayList<>();
    queueStatsIds.add(new QueueStatsId(ModelConstants.NULL_UUID));

    // Act
    List<QueueStats> actualFindQueueStatsByIdsResult =
        baseQueueStatsService.findQueueStatsByIds(ModelConstants.SYSTEM_TENANT, queueStatsIds);

    // Assert
    verify(queueStatsDao).findByIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindQueueStatsByIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseQueueStatsService#findByTenantIdAndNameAndServiceId(TenantId, String, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueStatsService#findByTenantIdAndNameAndServiceId(TenantId,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "QueueStats BaseQueueStatsService.findByTenantIdAndNameAndServiceId(TenantId, String, String)"
  })
  public void testFindByTenantIdAndNameAndServiceId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    when(queueStatsDao.findByTenantIdQueueNameAndServiceId(
            Mockito.<TenantId>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(queueStats);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    QueueStats actualFindByTenantIdAndNameAndServiceIdResult =
        baseQueueStatsService.findByTenantIdAndNameAndServiceId(tenantId, "Queue Name", "42");

    // Assert
    verify(tenantId).getId();
    verify(queueStatsDao)
        .findByTenantIdQueueNameAndServiceId(isA(TenantId.class), eq("Queue Name"), eq("42"));
    assertSame(queueStats, actualFindByTenantIdAndNameAndServiceIdResult);
  }

  /**
   * Test {@link BaseQueueStatsService#findByTenantIdAndNameAndServiceId(TenantId, String, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link QueueStats#QueueStats()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueStatsService#findByTenantIdAndNameAndServiceId(TenantId,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "QueueStats BaseQueueStatsService.findByTenantIdAndNameAndServiceId(TenantId, String, String)"
  })
  public void testFindByTenantIdAndNameAndServiceId_whenSystem_tenant_thenReturnQueueStats() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    when(queueStatsDao.findByTenantIdQueueNameAndServiceId(
            Mockito.<TenantId>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(queueStats);

    // Act
    QueueStats actualFindByTenantIdAndNameAndServiceIdResult =
        baseQueueStatsService.findByTenantIdAndNameAndServiceId(
            ModelConstants.SYSTEM_TENANT, "Queue Name", "42");

    // Assert
    verify(queueStatsDao)
        .findByTenantIdQueueNameAndServiceId(isA(TenantId.class), eq("Queue Name"), eq("42"));
    assertSame(queueStats, actualFindByTenantIdAndNameAndServiceIdResult);
  }

  /**
   * Test {@link BaseQueueStatsService#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueStatsService#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseQueueStatsService.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_givenBy_created_time_desc() {
    // Arrange
    PageData<QueueStats> emptyPageDataResult = PageData.emptyPageData();
    when(queueStatsDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<QueueStats> actualFindByTenantIdResult =
        baseQueueStatsService.findByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(queueStatsDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueStatsService#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueStatsService#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseQueueStatsService.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<QueueStats> emptyPageDataResult = PageData.emptyPageData();
    when(queueStatsDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<QueueStats> actualFindByTenantIdResult =
        baseQueueStatsService.findByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(queueStatsDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueStatsService#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueStatsService#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseQueueStatsService.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_givenSortOrderGetPropertyReturnNull_thenCallsGetProperty() {
    // Arrange
    PageData<QueueStats> emptyPageDataResult = PageData.emptyPageData();
    when(queueStatsDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<QueueStats> actualFindByTenantIdResult =
        baseQueueStatsService.findByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(queueStatsDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueStatsService#findByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueStatsService#findByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseQueueStatsService.findByTenantId(TenantId, PageLink)"})
  public void testFindByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<QueueStats> emptyPageDataResult = PageData.emptyPageData();
    when(queueStatsDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<QueueStats> actualFindByTenantIdResult =
        baseQueueStatsService.findByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(queueStatsDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueStatsService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueStatsService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseQueueStatsService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(queueStatsDao).deleteByTenantId(Mockito.<TenantId>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    baseQueueStatsService.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(queueStatsDao).deleteByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link BaseQueueStatsService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link QueueStatsDao#deleteByTenantId(TenantId)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueStatsService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
   * Test {@link BaseQueueStatsService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link AlarmId} {@link AlarmId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueStatsService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseQueueStatsService.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_givenNull_uuid_whenAlarmIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(queueStatsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    AlarmId id = mock(AlarmId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    baseQueueStatsService.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true);

    // Assert
    verify(id).getId();
    verify(queueStatsDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueStatsService#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then calls {@link QueueStatsDao#removeById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueStatsService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseQueueStatsService.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_whenNull_customer_id_thenCallsRemoveById() {
    // Arrange
    doNothing().when(queueStatsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    baseQueueStatsService.deleteEntity(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert
    verify(queueStatsDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueStatsService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link EntityId} {@link EntityId#getId()} return {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link EntityId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueStatsService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseQueueStatsService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    when(queueStatsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(queueStats);

    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        baseQueueStatsService.findEntity(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getId();
    verify(queueStatsDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(queueStats, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseQueueStatsService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link BaseQueueStatsService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseQueueStatsService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    when(queueStatsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(queueStats);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        baseQueueStatsService.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(queueStatsDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(queueStats, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseQueueStatsService#getEntityType()}.
   *
   * <p>Method under test: {@link BaseQueueStatsService#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType BaseQueueStatsService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    JpaQueueStatsDao queueStatsDao = new JpaQueueStatsDao();
    BaseQueueStatsService baseQueueStatsService =
        new BaseQueueStatsService(queueStatsDao, new QueueStatsDataValidator());

    // Act and Assert
    assertEquals(EntityType.QUEUE_STATS, baseQueueStatsService.getEntityType());
  }
}
