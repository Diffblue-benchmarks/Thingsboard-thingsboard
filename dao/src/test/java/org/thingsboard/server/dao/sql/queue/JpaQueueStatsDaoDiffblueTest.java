package org.thingsboard.server.dao.sql.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.QueueStatsId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.queue.QueueStats;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.QueueStatsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaQueueStatsDao.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class JpaQueueStatsDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaQueueStatsDao jpaQueueStatsDao;

  @MockBean
  private QueueStatsRepository queueStatsRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaQueueStatsDao#getEntityClass()}
   *   <li>{@link JpaQueueStatsDao#getEntityType()}
   *   <li>{@link JpaQueueStatsDao#getRepository()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    JpaQueueStatsDao jpaQueueStatsDao = new JpaQueueStatsDao();

    // Act
    Class<QueueStatsEntity> actualEntityClass = jpaQueueStatsDao.getEntityClass();
    EntityType actualEntityType = jpaQueueStatsDao.getEntityType();

    // Assert
    assertNull(jpaQueueStatsDao.getRepository());
    assertEquals(EntityType.QUEUE_STATS, actualEntityType);
    Class<QueueStatsEntity> expectedEntityClass = QueueStatsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test
   * {@link JpaQueueStatsDao#findByTenantIdQueueNameAndServiceId(TenantId, String, String)}.
   * <p>
   * Method under test:
   * {@link JpaQueueStatsDao#findByTenantIdQueueNameAndServiceId(TenantId, String, String)}
   */
  @Test
  public void testFindByTenantIdQueueNameAndServiceId() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);
    when(queueStatsRepository.findByTenantIdAndQueueNameAndServiceId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(queueStatsEntity);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    QueueStats actualFindByTenantIdQueueNameAndServiceIdResult = jpaQueueStatsDao
        .findByTenantIdQueueNameAndServiceId(tenantId, "Queue Name", "42");

    // Assert
    verify(queueStatsRepository).findByTenantIdAndQueueNameAndServiceId(isA(UUID.class), eq("Queue Name"), eq("42"));
    UUID uuidId = actualFindByTenantIdQueueNameAndServiceIdResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("42", actualFindByTenantIdQueueNameAndServiceIdResult.getServiceId());
    assertEquals("Queue Name", actualFindByTenantIdQueueNameAndServiceIdResult.getQueueName());
    assertEquals(1L, actualFindByTenantIdQueueNameAndServiceIdResult.getCreatedTime());
    QueueStatsId id = actualFindByTenantIdQueueNameAndServiceIdResult.getId();
    assertEquals(EntityType.QUEUE_STATS, id.getEntityType());
    assertTrue(id.isNullUid());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertEquals(expectedTenantId, actualFindByTenantIdQueueNameAndServiceIdResult.getTenantId());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test
   * {@link JpaQueueStatsDao#findByTenantIdQueueNameAndServiceId(TenantId, String, String)}.
   * <ul>
   *   <li>Then return {@link QueueStats#QueueStats()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaQueueStatsDao#findByTenantIdQueueNameAndServiceId(TenantId, String, String)}
   */
  @Test
  public void testFindByTenantIdQueueNameAndServiceId_thenReturnQueueStats() {
    // Arrange
    QueueStatsEntity queueStatsEntity = mock(QueueStatsEntity.class);
    QueueStats queueStats = new QueueStats();
    when(queueStatsEntity.toData()).thenReturn(queueStats);
    doNothing().when(queueStatsEntity).setCreatedTime(anyLong());
    doNothing().when(queueStatsEntity).setId(Mockito.<UUID>any());
    doNothing().when(queueStatsEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(queueStatsEntity).setQueueName(Mockito.<String>any());
    doNothing().when(queueStatsEntity).setServiceId(Mockito.<String>any());
    doNothing().when(queueStatsEntity).setTenantId(Mockito.<UUID>any());
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);
    when(queueStatsRepository.findByTenantIdAndQueueNameAndServiceId(Mockito.<UUID>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(queueStatsEntity);

    // Act
    QueueStats actualFindByTenantIdQueueNameAndServiceIdResult = jpaQueueStatsDao
        .findByTenantIdQueueNameAndServiceId(ModelConstants.SYSTEM_TENANT, "Queue Name", "42");

    // Assert
    verify(queueStatsEntity).setCreatedTime(eq(1L));
    verify(queueStatsEntity).setId(isA(UUID.class));
    verify(queueStatsEntity).setUuid(isA(UUID.class));
    verify(queueStatsEntity).setQueueName(eq("Queue Name"));
    verify(queueStatsEntity).setServiceId(eq("42"));
    verify(queueStatsEntity).setTenantId(isA(UUID.class));
    verify(queueStatsEntity).toData();
    verify(queueStatsRepository).findByTenantIdAndQueueNameAndServiceId(isA(UUID.class), eq("Queue Name"), eq("42"));
    assertSame(queueStats, actualFindByTenantIdQueueNameAndServiceIdResult);
  }

  /**
   * Test {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantId() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<QueueStatsEntity> content = new ArrayList<>();
    content.add(queueStatsEntity);
    PageImpl<QueueStatsEntity> pageImpl = new PageImpl<>(content);
    when(queueStatsRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    PageData<QueueStats> actualFindByTenantIdResult = jpaQueueStatsDao.findByTenantId(tenantId,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(queueStatsRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    List<QueueStats> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    QueueStats getResult = data.get(0);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("42", getResult.getServiceId());
    assertEquals("Queue Name", getResult.getQueueName());
    assertEquals(1L, getResult.getCreatedTime());
    QueueStatsId id = getResult.getId();
    assertEquals(EntityType.QUEUE_STATS, id.getEntityType());
    assertTrue(id.isNullUid());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertEquals(expectedTenantId, getResult.getTenantId());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantId_givenOne_thenReturnTotalElementsIsZero() {
    // Arrange
    when(queueStatsRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<QueueStats> actualFindByTenantIdResult = jpaQueueStatsDao.findByTenantId(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(queueStatsRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return Data first is {@link QueueStats#QueueStats()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantId_thenReturnDataFirstIsQueueStats() {
    // Arrange
    QueueStatsEntity queueStatsEntity = mock(QueueStatsEntity.class);
    QueueStats queueStats = new QueueStats();
    when(queueStatsEntity.toData()).thenReturn(queueStats);
    doNothing().when(queueStatsEntity).setCreatedTime(anyLong());
    doNothing().when(queueStatsEntity).setId(Mockito.<UUID>any());
    doNothing().when(queueStatsEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(queueStatsEntity).setQueueName(Mockito.<String>any());
    doNothing().when(queueStatsEntity).setServiceId(Mockito.<String>any());
    doNothing().when(queueStatsEntity).setTenantId(Mockito.<UUID>any());
    queueStatsEntity.setCreatedTime(-1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("42");
    queueStatsEntity.setServiceId("org.thingsboard.server.dao.model.sql.QueueStatsEntity");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<QueueStatsEntity> content = new ArrayList<>();
    content.add(queueStatsEntity);
    PageImpl<QueueStatsEntity> pageImpl = new PageImpl<>(content);
    when(queueStatsRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(pageImpl);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getPageSize()).thenReturn(3);
    when(pageLink.getTextSearch()).thenReturn("Text Search");
    when(pageLink.toSort(Mockito.<SortOrder>any(), Mockito.<Map<String, String>>any(), anyBoolean()))
        .thenReturn(Sort.unsorted());
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));

    // Act
    PageData<QueueStats> actualFindByTenantIdResult = jpaQueueStatsDao.findByTenantId(ModelConstants.SYSTEM_TENANT,
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(pageLink).getTextSearch();
    verify(pageLink).toSort(isA(SortOrder.class), isA(Map.class), eq(true));
    verify(queueStatsEntity).setCreatedTime(eq(-1L));
    verify(queueStatsEntity).setId(isA(UUID.class));
    verify(queueStatsEntity).setUuid(isA(UUID.class));
    verify(queueStatsEntity).setQueueName(eq("42"));
    verify(queueStatsEntity).setServiceId(eq("org.thingsboard.server.dao.model.sql.QueueStatsEntity"));
    verify(queueStatsEntity).setTenantId(isA(UUID.class));
    verify(queueStatsEntity).toData();
    verify(queueStatsRepository).findByTenantId(isA(UUID.class), eq("Text Search"), isA(Pageable.class));
    List<QueueStats> data = actualFindByTenantIdResult.getData();
    assertEquals(1, data.size());
    assertSame(queueStats, data.get(0));
  }

  /**
   * Test {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return TotalElements is zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaQueueStatsDao#findByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindByTenantId_whenFirst_page_thenReturnTotalElementsIsZero() {
    // Arrange
    when(queueStatsRepository.findByTenantId(Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<Pageable>any()))
        .thenReturn(new PageImpl<>(new ArrayList<>()));

    // Act
    PageData<QueueStats> actualFindByTenantIdResult = jpaQueueStatsDao.findByTenantId(ModelConstants.SYSTEM_TENANT,
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(queueStatsRepository).findByTenantId(isA(UUID.class), isNull(), isA(Pageable.class));
    assertEquals(0L, actualFindByTenantIdResult.getTotalElements());
    assertEquals(1, actualFindByTenantIdResult.getTotalPages());
    assertFalse(actualFindByTenantIdResult.hasNext());
    assertTrue(actualFindByTenantIdResult.getData().isEmpty());
  }

  /**
   * Test {@link JpaQueueStatsDao#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link QueueStatsRepository#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueStatsDao#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(queueStatsRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaQueueStatsDao.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert that nothing has changed
    verify(queueStatsRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaQueueStatsDao#findByIds(TenantId, List)}.
   * <ul>
   *   <li>Then return first is {@link QueueStats#QueueStats()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueStatsDao#findByIds(TenantId, List)}
   */
  @Test
  public void testFindByIds_thenReturnFirstIsQueueStats() {
    // Arrange
    QueueStatsEntity queueStatsEntity = mock(QueueStatsEntity.class);
    QueueStats queueStats = new QueueStats();
    when(queueStatsEntity.toData()).thenReturn(queueStats);
    doNothing().when(queueStatsEntity).setCreatedTime(anyLong());
    doNothing().when(queueStatsEntity).setId(Mockito.<UUID>any());
    doNothing().when(queueStatsEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(queueStatsEntity).setQueueName(Mockito.<String>any());
    doNothing().when(queueStatsEntity).setServiceId(Mockito.<String>any());
    doNothing().when(queueStatsEntity).setTenantId(Mockito.<UUID>any());
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<QueueStatsEntity> queueStatsEntityList = new ArrayList<>();
    queueStatsEntityList.add(queueStatsEntity);
    when(queueStatsRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(queueStatsEntityList);

    // Act
    List<QueueStats> actualFindByIdsResult = jpaQueueStatsDao.findByIds(ModelConstants.SYSTEM_TENANT,
        new ArrayList<>());

    // Assert
    verify(queueStatsEntity).setCreatedTime(eq(1L));
    verify(queueStatsEntity).setId(isA(UUID.class));
    verify(queueStatsEntity).setUuid(isA(UUID.class));
    verify(queueStatsEntity).setQueueName(eq("Queue Name"));
    verify(queueStatsEntity).setServiceId(eq("42"));
    verify(queueStatsEntity).setTenantId(isA(UUID.class));
    verify(queueStatsEntity).toData();
    verify(queueStatsRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindByIdsResult.size());
    assertSame(queueStats, actualFindByIdsResult.get(0));
  }

  /**
   * Test {@link JpaQueueStatsDao#findByIds(TenantId, List)}.
   * <ul>
   *   <li>Then return first UuidId toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueStatsDao#findByIds(TenantId, List)}
   */
  @Test
  public void testFindByIds_thenReturnFirstUuidIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(ModelConstants.NULL_UUID);
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    queueStatsEntity.setTenantId(ModelConstants.NULL_UUID);
    queueStatsEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<QueueStatsEntity> queueStatsEntityList = new ArrayList<>();
    queueStatsEntityList.add(queueStatsEntity);
    when(queueStatsRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(queueStatsEntityList);
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    List<QueueStats> actualFindByIdsResult = jpaQueueStatsDao.findByIds(tenantId, new ArrayList<>());

    // Assert
    verify(queueStatsRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindByIdsResult.size());
    QueueStats getResult = actualFindByIdsResult.get(0);
    UUID uuidId = getResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("42", getResult.getServiceId());
    assertEquals("Queue Name", getResult.getQueueName());
    assertEquals(1L, getResult.getCreatedTime());
    QueueStatsId id = getResult.getId();
    assertEquals(EntityType.QUEUE_STATS, id.getEntityType());
    assertTrue(id.isNullUid());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertEquals(expectedTenantId, getResult.getTenantId());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByIds(TenantId, List)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueStatsDao#findByIds(TenantId, List)}
   */
  @Test
  public void testFindByIds_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(queueStatsRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<QueueStats> actualFindByIdsResult = jpaQueueStatsDao.findByIds(ModelConstants.SYSTEM_TENANT,
        new ArrayList<>());

    // Assert
    verify(queueStatsRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }
}
