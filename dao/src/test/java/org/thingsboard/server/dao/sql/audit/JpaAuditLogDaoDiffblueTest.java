package org.thingsboard.server.dao.sql.audit;

import static org.junit.Assert.assertEquals;
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
import org.thingsboard.server.dao.model.sql.AuditLogEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {JpaAuditLogDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaAuditLogDaoDiffblueTest {
  @MockBean
  private AuditLogRepository auditLogRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaAuditLogDao jpaAuditLogDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private SqlPartitioningRepository sqlPartitioningRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaAuditLogDao#cleanUpAuditLogs(long)}.
   * <p>
   * Method under test: {@link JpaAuditLogDao#cleanUpAuditLogs(long)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaAuditLogDao.cleanUpAuditLogs(long)"})
  public void testCleanUpAuditLogs() {
    // Arrange
    when(sqlPartitioningRepository.dropPartitionsBefore(Mockito.<String>any(), anyLong(), anyLong())).thenReturn(1L);

    // Act
    jpaAuditLogDao.cleanUpAuditLogs(1L);

    // Assert
    verify(sqlPartitioningRepository).dropPartitionsBefore(eq("audit_log"), eq(1L), eq(604800000L));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaAuditLogDao#getEntityClass()}
   *   <li>{@link JpaAuditLogDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaAuditLogDao.getEntityClass()",
      "org.springframework.data.jpa.repository.JpaRepository JpaAuditLogDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaAuditLogDao jpaAuditLogDao = new JpaAuditLogDao(mock(AuditLogRepository.class),
        mock(SqlPartitioningRepository.class));

    // Act
    Class<AuditLogEntity> actualEntityClass = jpaAuditLogDao.getEntityClass();
    jpaAuditLogDao.getRepository();

    // Assert
    Class<AuditLogEntity> expectedEntityClass = AuditLogEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
