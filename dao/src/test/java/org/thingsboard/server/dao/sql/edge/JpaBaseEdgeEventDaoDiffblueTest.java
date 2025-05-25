package org.thingsboard.server.dao.sql.edge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
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
import org.thingsboard.server.common.stats.DefaultStatsFactory;
import org.thingsboard.server.common.stats.StatsFactory;
import org.thingsboard.server.dao.model.sql.EdgeEventEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sql.ScheduledLogExecutorComponent;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {JpaBaseEdgeEventDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaBaseEdgeEventDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EdgeEventInsertRepository edgeEventInsertRepository;

  @MockBean
  private EdgeEventRepository edgeEventRepository;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaBaseEdgeEventDao jpaBaseEdgeEventDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private ScheduledLogExecutorComponent scheduledLogExecutorComponent;

  @MockBean
  private SqlPartitioningRepository sqlPartitioningRepository;

  @MockBean
  private StatsFactory statsFactory;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaBaseEdgeEventDao#getEntityClass()}
   *   <li>{@link JpaBaseEdgeEventDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaBaseEdgeEventDao.getEntityClass()",
      "org.springframework.data.jpa.repository.JpaRepository JpaBaseEdgeEventDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    ScheduledLogExecutorComponent logExecutor = new ScheduledLogExecutorComponent();
    JpaBaseEdgeEventDao jpaBaseEdgeEventDao = new JpaBaseEdgeEventDao(logExecutor, new DefaultStatsFactory(),
        mock(EdgeEventRepository.class), mock(EdgeEventInsertRepository.class), mock(SqlPartitioningRepository.class),
        mock(JdbcTemplate.class));

    // Act
    Class<EdgeEventEntity> actualEntityClass = jpaBaseEdgeEventDao.getEntityClass();
    jpaBaseEdgeEventDao.getRepository();

    // Assert
    Class<EdgeEventEntity> expectedEntityClass = EdgeEventEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#cleanupEvents(long)}.
   * <ul>
   *   <li>Given {@link SqlPartitioningRepository} {@link SqlPartitioningRepository#dropPartitionsBefore(String, long, long)} return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEdgeEventDao#cleanupEvents(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaBaseEdgeEventDao.cleanupEvents(long)"})
  public void testCleanupEvents_givenSqlPartitioningRepositoryDropPartitionsBeforeReturnOne() {
    // Arrange
    when(sqlPartitioningRepository.dropPartitionsBefore(Mockito.<String>any(), anyLong(), anyLong())).thenReturn(1L);

    // Act
    jpaBaseEdgeEventDao.cleanupEvents(1L);

    // Assert
    verify(sqlPartitioningRepository).dropPartitionsBefore(eq("edge_event"), eq(1L), eq(604800000L));
  }

  /**
   * Test {@link JpaBaseEdgeEventDao#cleanupEvents(long)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseEdgeEventDao#cleanupEvents(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaBaseEdgeEventDao.cleanupEvents(long)"})
  public void testCleanupEvents_thenThrowRuntimeException() {
    // Arrange
    when(sqlPartitioningRepository.dropPartitionsBefore(Mockito.<String>any(), anyLong(), anyLong()))
        .thenThrow(new RuntimeException("edge_event"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> jpaBaseEdgeEventDao.cleanupEvents(1L));
    verify(sqlPartitioningRepository).dropPartitionsBefore(eq("edge_event"), eq(1L), eq(604800000L));
  }
}
