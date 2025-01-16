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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
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
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.QueueStatsId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.queue.QueueStats;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.service.validator.QueueStatsDataValidator;
import org.thingsboard.server.dao.sql.queue.JpaQueueStatsDao;

@ContextConfiguration(classes = {BaseQueueStatsService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class BaseQueueStatsServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  private BaseQueueStatsService baseQueueStatsService;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DataValidator<QueueStats> dataValidator;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private QueueStatsDao queueStatsDao;

  @MockBean
  private RelationService relationService;

  /**
   * Test {@link BaseQueueStatsService#save(TenantId, QueueStats)}.
   * <p>
   * Method under test: {@link BaseQueueStatsService#save(TenantId, QueueStats)}
   */
  @Test
  public void testSave() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    when(queueStatsDao.save(Mockito.<TenantId>any(), Mockito.<QueueStats>any())).thenReturn(queueStats);
    when(dataValidator.validate(Mockito.<QueueStats>any(), Mockito.<Function<QueueStats, TenantId>>any()))
        .thenReturn(new QueueStats());

    // Act
    QueueStats actualSaveResult = baseQueueStatsService.save(ModelConstants.SYSTEM_TENANT, new QueueStats());

    // Assert
    verify(queueStatsDao).save(isA(TenantId.class), isA(QueueStats.class));
    verify(dataValidator).validate(isA(QueueStats.class), isA(Function.class));
    assertSame(queueStats, actualSaveResult);
  }

  /**
   * Test
   * {@link BaseQueueStatsService#findQueueStatsById(TenantId, QueueStatsId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueStatsService#findQueueStatsById(TenantId, QueueStatsId)}
   */
  @Test
  public void testFindQueueStatsById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    when(queueStatsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queueStats);
    QueueStatsId queueStatsId = mock(QueueStatsId.class);
    when(queueStatsId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    QueueStats actualFindQueueStatsByIdResult = baseQueueStatsService.findQueueStatsById(ModelConstants.SYSTEM_TENANT,
        queueStatsId);

    // Assert
    verify(queueStatsId, atLeast(1)).getId();
    verify(queueStatsDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(queueStats, actualFindQueueStatsByIdResult);
  }

  /**
   * Test
   * {@link BaseQueueStatsService#findQueueStatsById(TenantId, QueueStatsId)}.
   * <ul>
   *   <li>When {@link QueueStatsId#QueueStatsId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link QueueStats#QueueStats()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueStatsService#findQueueStatsById(TenantId, QueueStatsId)}
   */
  @Test
  public void testFindQueueStatsById_whenQueueStatsIdWithIdIsNull_uuid_thenReturnQueueStats() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    when(queueStatsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queueStats);

    // Act
    QueueStats actualFindQueueStatsByIdResult = baseQueueStatsService.findQueueStatsById(ModelConstants.SYSTEM_TENANT,
        new QueueStatsId(ModelConstants.NULL_UUID));

    // Assert
    verify(queueStatsDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(queueStats, actualFindQueueStatsByIdResult);
  }

  /**
   * Test {@link BaseQueueStatsService#findQueueStatsByIds(TenantId, List)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueStatsService#findQueueStatsByIds(TenantId, List)}
   */
  @Test
  public void testFindQueueStatsByIds_thenReturnEmpty() {
    // Arrange
    when(queueStatsDao.findByIds(Mockito.<TenantId>any(), Mockito.<List<QueueStatsId>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<QueueStatsId> queueStatsIds = new ArrayList<>();
    queueStatsIds.add(new QueueStatsId(ModelConstants.NULL_UUID));

    // Act
    List<QueueStats> actualFindQueueStatsByIdsResult = baseQueueStatsService
        .findQueueStatsByIds(ModelConstants.SYSTEM_TENANT, queueStatsIds);

    // Assert
    verify(queueStatsDao).findByIds(isA(TenantId.class), isA(List.class));
    assertTrue(actualFindQueueStatsByIdsResult.isEmpty());
  }

  /**
   * Test
   * {@link BaseQueueStatsService#findByTenantIdAndNameAndServiceId(TenantId, String, String)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link QueueStats#QueueStats()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueStatsService#findByTenantIdAndNameAndServiceId(TenantId, String, String)}
   */
  @Test
  public void testFindByTenantIdAndNameAndServiceId_whenSystem_tenant_thenReturnQueueStats() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    when(queueStatsDao.findByTenantIdQueueNameAndServiceId(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(queueStats);

    // Act
    QueueStats actualFindByTenantIdAndNameAndServiceIdResult = baseQueueStatsService
        .findByTenantIdAndNameAndServiceId(ModelConstants.SYSTEM_TENANT, "Queue Name", "42");

    // Assert
    verify(queueStatsDao).findByTenantIdQueueNameAndServiceId(isA(TenantId.class), eq("Queue Name"), eq("42"));
    assertSame(queueStats, actualFindByTenantIdAndNameAndServiceIdResult);
  }

  /**
   * Test {@link BaseQueueStatsService#findByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   *   <li>Then calls {@link PageLink#getPage()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueStatsService#findByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenSortOrderWithPropertyAndDirectionIsAsc_thenCallsGetPage() {
    // Arrange
    PageData<QueueStats> emptyPageDataResult = PageData.emptyPageData();
    when(queueStatsDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<QueueStats> actualFindByTenantIdResult = baseQueueStatsService.findByTenantId(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(queueStatsDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindByTenantIdResult.EMPTY_PAGE_DATA, actualFindByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueStatsService#findByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with property is empty string and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueStatsService#findByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenSortOrderWithPropertyIsEmptyStringAndDirectionIsAsc() {
    // Arrange
    PageData<QueueStats> emptyPageDataResult = PageData.emptyPageData();
    when(queueStatsDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<QueueStats> actualFindByTenantIdResult = baseQueueStatsService.findByTenantId(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(queueStatsDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindByTenantIdResult.EMPTY_PAGE_DATA, actualFindByTenantIdResult);
  }

  /**
   * Test {@link BaseQueueStatsService#findByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueStatsService#findByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<QueueStats> emptyPageDataResult = PageData.emptyPageData();
    when(queueStatsDao.findByTenantId(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<QueueStats> actualFindByTenantIdResult = baseQueueStatsService.findByTenantId(ModelConstants.SYSTEM_TENANT,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(queueStatsDao).findByTenantId(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindByTenantIdResult.EMPTY_PAGE_DATA, actualFindByTenantIdResult);
  }

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
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(queueStatsDao).deleteByTenantId(Mockito.<TenantId>any());

    // Act
    baseQueueStatsService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(queueStatsDao).deleteByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link BaseQueueStatsService#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link AlarmId} {@link UUIDBased#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueStatsService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_givenNull_uuid_whenAlarmIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(queueStatsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    AlarmId id = mock(AlarmId.class);
    when(id.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    baseQueueStatsService.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true);

    // Assert that nothing has changed
    verify(id).getId();
    verify(queueStatsDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueStatsService#deleteEntity(TenantId, EntityId, boolean)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then calls {@link Dao#removeById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueStatsService#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  public void testDeleteEntity_whenNull_customer_id_thenCallsRemoveById() {
    // Arrange
    doNothing().when(queueStatsDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    baseQueueStatsService.deleteEntity(ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert that nothing has changed
    verify(queueStatsDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseQueueStatsService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>When {@link EntityId} {@link EntityId#getId()} return
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueStatsService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_givenNull_uuid_whenEntityIdGetIdReturnNull_uuid_thenCallsGetId() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    when(queueStatsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queueStats);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    Optional<HasId<?>> actualFindEntityResult = baseQueueStatsService.findEntity(ModelConstants.SYSTEM_TENANT,
        entityId);

    // Assert
    verify(entityId).getId();
    verify(queueStatsDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(queueStats, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseQueueStatsService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseQueueStatsService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    QueueStats queueStats = new QueueStats();
    when(queueStatsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(queueStats);

    // Act
    Optional<HasId<?>> actualFindEntityResult = baseQueueStatsService.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(queueStatsDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(queueStats, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseQueueStatsService#getEntityType()}.
   * <p>
   * Method under test: {@link BaseQueueStatsService#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange
    JpaQueueStatsDao queueStatsDao = new JpaQueueStatsDao();

    // Act and Assert
    assertEquals(EntityType.QUEUE_STATS,
        (new BaseQueueStatsService(queueStatsDao, new QueueStatsDataValidator())).getEntityType());
  }
}
