package org.thingsboard.server.dao.sql;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.postgresql.util.PSQLWarning;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.dao.sql.alarm.AlarmRepository;
import org.thingsboard.server.dao.sql.alarm.EntityAlarmRepository;
import org.thingsboard.server.dao.sql.alarm.JpaAlarmDao;
import org.thingsboard.server.dao.sql.query.AlarmQueryRepository;

@ContextConfiguration(classes = {JpaAlarmDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaAbstractDaoListeningExecutorServiceDiffblueTest {
  @MockBean
  private AlarmQueryRepository alarmQueryRepository;

  @MockBean
  private AlarmRepository alarmRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityAlarmRepository entityAlarmRepository;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaAbstractDaoListeningExecutorService jpaAbstractDaoListeningExecutorService;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaAbstractDaoListeningExecutorService#printWarnings(Statement)}.
   * <ul>
   *   <li>Given {@link JpaAlarmDao} (default constructor).</li>
   *   <li>Then throw {@link SQLWarning}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDaoListeningExecutorService#printWarnings(Statement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaAbstractDaoListeningExecutorService.printWarnings(Statement)"})
  public void testPrintWarnings_givenJpaAlarmDao_thenThrowSQLWarning() throws SQLException {
    // Arrange
    JpaAlarmDao jpaAlarmDao = new JpaAlarmDao();
    Statement statement = mock(Statement.class);
    when(statement.getWarnings()).thenThrow(new SQLWarning());

    // Act and Assert
    assertThrows(SQLWarning.class, () -> jpaAlarmDao.printWarnings(statement));
    verify(statement).getWarnings();
  }

  /**
   * Test {@link JpaAbstractDaoListeningExecutorService#printWarnings(Statement)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link Statement} {@link Statement#getWarnings()} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDaoListeningExecutorService#printWarnings(Statement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaAbstractDaoListeningExecutorService.printWarnings(Statement)"})
  public void testPrintWarnings_givenNull_whenStatementGetWarningsReturnNull() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.getWarnings()).thenReturn(null);

    // Act
    jpaAbstractDaoListeningExecutorService.printWarnings(statement);

    // Assert
    verify(statement).getWarnings();
  }

  /**
   * Test {@link JpaAbstractDaoListeningExecutorService#printWarnings(Statement)}.
   * <ul>
   *   <li>Given {@link SQLWarning#SQLWarning()}.</li>
   *   <li>When {@link Statement} {@link Statement#getWarnings()} return {@link SQLWarning#SQLWarning()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDaoListeningExecutorService#printWarnings(Statement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaAbstractDaoListeningExecutorService.printWarnings(Statement)"})
  public void testPrintWarnings_givenSQLWarning_whenStatementGetWarningsReturnSQLWarning() throws SQLException {
    // Arrange
    Statement statement = mock(Statement.class);
    when(statement.getWarnings()).thenReturn(new SQLWarning());

    // Act
    jpaAbstractDaoListeningExecutorService.printWarnings(statement);

    // Assert
    verify(statement).getWarnings();
  }

  /**
   * Test {@link JpaAbstractDaoListeningExecutorService#printWarnings(Statement)}.
   * <ul>
   *   <li>Then calls {@link SQLWarning#getNextWarning()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaAbstractDaoListeningExecutorService#printWarnings(Statement)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaAbstractDaoListeningExecutorService.printWarnings(Statement)"})
  public void testPrintWarnings_thenCallsGetNextWarning() throws SQLException {
    // Arrange
    PSQLWarning psqlWarning = mock(PSQLWarning.class);
    when(psqlWarning.getMessage()).thenReturn("Not all who wander are lost");
    when(psqlWarning.getNextWarning()).thenReturn(new SQLWarning());
    Statement statement = mock(Statement.class);
    when(statement.getWarnings()).thenReturn(psqlWarning);

    // Act
    jpaAbstractDaoListeningExecutorService.printWarnings(statement);

    // Assert
    verify(psqlWarning).getNextWarning();
    verify(statement).getWarnings();
    verify(psqlWarning).getMessage();
  }
}
