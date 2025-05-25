package org.thingsboard.server.dao.sql.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.QueueStatsId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.queue.QueueStats;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.QueueStatsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaQueueStatsDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaQueueStatsDao.getEntityClass()", "EntityType JpaQueueStatsDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaQueueStatsDao.getRepository()"})
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
   * Test {@link JpaQueueStatsDao#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link QueueStatsRepository#deleteByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueStatsDao#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaQueueStatsDao.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_whenSystem_tenant_thenCallsDeleteByTenantId() {
    // Arrange
    doNothing().when(queueStatsRepository).deleteByTenantId(Mockito.<UUID>any());

    // Act
    jpaQueueStatsDao.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(queueStatsRepository).deleteByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link JpaQueueStatsDao#findByIds(TenantId, List)}.
   * <p>
   * Method under test: {@link JpaQueueStatsDao#findByIds(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaQueueStatsDao.findByIds(TenantId, List)"})
  public void testFindByIds() {
    // Arrange
    when(queueStatsRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<QueueStatsId> queueStatsIds = new ArrayList<>();
    queueStatsIds.add(new QueueStatsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    List<QueueStats> actualFindByIdsResult = jpaQueueStatsDao.findByIds(ModelConstants.SYSTEM_TENANT, queueStatsIds);

    // Assert
    verify(queueStatsRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByIds(TenantId, List)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueStatsDao#findByIds(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaQueueStatsDao.findByIds(TenantId, List)"})
  public void testFindByIds_givenNull_whenArrayListAddNull_thenReturnEmpty() {
    // Arrange
    when(queueStatsRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<QueueStatsId> queueStatsIds = new ArrayList<>();
    queueStatsIds.add(null);

    // Act
    List<QueueStats> actualFindByIdsResult = jpaQueueStatsDao.findByIds(ModelConstants.SYSTEM_TENANT, queueStatsIds);

    // Assert
    verify(queueStatsRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByIdsResult.isEmpty());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByIds(TenantId, List)}.
   * <ul>
   *   <li>Given {@link QueueStatsEntity#QueueStatsEntity()} CreatedTime is one.</li>
   *   <li>Then return first ServiceId is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueStatsDao#findByIds(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaQueueStatsDao.findByIds(TenantId, List)"})
  public void testFindByIds_givenQueueStatsEntityCreatedTimeIsOne_thenReturnFirstServiceIdIs42() {
    // Arrange
    QueueStatsEntity queueStatsEntity = new QueueStatsEntity();
    queueStatsEntity.setCreatedTime(1L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName("Queue Name");
    queueStatsEntity.setServiceId("42");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    queueStatsEntity.setTenantId(tenantId);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    queueStatsEntity.setUuid(id);

    ArrayList<QueueStatsEntity> queueStatsEntityList = new ArrayList<>();
    queueStatsEntityList.add(queueStatsEntity);
    when(queueStatsRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(queueStatsEntityList);

    // Act
    List<QueueStats> actualFindByIdsResult = jpaQueueStatsDao.findByIds(ModelConstants.SYSTEM_TENANT,
        new ArrayList<>());

    // Assert
    verify(queueStatsRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindByIdsResult.size());
    QueueStats getResult = actualFindByIdsResult.get(0);
    assertEquals("42", getResult.getServiceId());
    UUID uuidId = getResult.getUuidId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", uuidId.toString());
    assertEquals("Queue Name", getResult.getQueueName());
    assertEquals(1L, getResult.getCreatedTime());
    QueueStatsId id2 = getResult.getId();
    assertEquals(EntityType.QUEUE_STATS, id2.getEntityType());
    TenantId tenantId2 = getResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(id2.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(id, uuidId);
    assertSame(id, id2.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link JpaQueueStatsDao#findByIds(TenantId, List)}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueStatsDao#findByIds(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaQueueStatsDao.findByIds(TenantId, List)"})
  public void testFindByIds_thenCallsGetId() {
    // Arrange
    when(queueStatsRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(new ArrayList<>());
    QueueStatsId queueStatsId = mock(QueueStatsId.class);
    when(queueStatsId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<QueueStatsId> queueStatsIds = new ArrayList<>();
    queueStatsIds.add(queueStatsId);

    // Act
    List<QueueStats> actualFindByIdsResult = jpaQueueStatsDao.findByIds(ModelConstants.SYSTEM_TENANT, queueStatsIds);

    // Assert
    verify(queueStatsId).getId();
    verify(queueStatsRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertTrue(actualFindByIdsResult.isEmpty());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaQueueStatsDao.findByIds(TenantId, List)"})
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
    queueStatsEntity.setCreatedTime(0L);
    queueStatsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setQueueName("org.thingsboard.server.dao.model.sql.QueueStatsEntity");
    queueStatsEntity.setServiceId("Service Id");
    queueStatsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    queueStatsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<QueueStatsEntity> queueStatsEntityList = new ArrayList<>();
    queueStatsEntityList.add(queueStatsEntity);
    when(queueStatsRepository.findByTenantIdAndIdIn(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(queueStatsEntityList);
    QueueStatsId queueStatsId = mock(QueueStatsId.class);
    when(queueStatsId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<QueueStatsId> queueStatsIds = new ArrayList<>();
    queueStatsIds.add(queueStatsId);

    // Act
    List<QueueStats> actualFindByIdsResult = jpaQueueStatsDao.findByIds(ModelConstants.SYSTEM_TENANT, queueStatsIds);

    // Assert
    verify(queueStatsId).getId();
    verify(queueStatsEntity).setCreatedTime(eq(0L));
    verify(queueStatsEntity).setId(isA(UUID.class));
    verify(queueStatsEntity).setUuid(isA(UUID.class));
    verify(queueStatsEntity).setQueueName(eq("org.thingsboard.server.dao.model.sql.QueueStatsEntity"));
    verify(queueStatsEntity).setServiceId(eq("Service Id"));
    verify(queueStatsEntity).setTenantId(isA(UUID.class));
    verify(queueStatsEntity).toData();
    verify(queueStatsRepository).findByTenantIdAndIdIn(isA(UUID.class), isA(List.class));
    assertEquals(1, actualFindByIdsResult.size());
    assertSame(queueStats, actualFindByIdsResult.get(0));
  }

  /**
   * Test {@link JpaQueueStatsDao#findByIds(TenantId, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaQueueStatsDao#findByIds(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List JpaQueueStatsDao.findByIds(TenantId, List)"})
  public void testFindByIds_whenArrayList_thenReturnEmpty() {
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
