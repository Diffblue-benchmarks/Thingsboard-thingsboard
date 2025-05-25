package org.thingsboard.server.dao.sql.event;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.transaction.SystemException;
import jakarta.transaction.TransactionManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {EventInsertRepository.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class EventInsertRepositoryDiffblueTest {
  @Autowired
  private EventInsertRepository eventInsertRepository;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link EventInsertRepository#save(List)}.
   * <ul>
   *   <li>Given {@link JdbcTemplate}.</li>
   *   <li>Then calls {@link TransactionTemplate#execute(TransactionCallback)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventInsertRepository#save(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventInsertRepository.save(List)"})
  public void testSave_givenJdbcTemplate_thenCallsExecute() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn("Execute");

    // Act
    eventInsertRepository.save(new ArrayList<>());

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }

  /**
   * Test {@link EventInsertRepository#save(List)}.
   * <ul>
   *   <li>Given {@link TransactionManager} {@link TransactionManager#getStatus()} return one.</li>
   *   <li>Then calls {@link TransactionManager#getStatus()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventInsertRepository#save(List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventInsertRepository.save(List)"})
  public void testSave_givenTransactionManagerGetStatusReturnOne_thenCallsGetStatus() throws SystemException {
    // Arrange
    TransactionManager transactionManager = mock(TransactionManager.class);
    when(transactionManager.getStatus()).thenReturn(1);
    JtaTransactionManager transactionManager2 = new JtaTransactionManager(transactionManager);

    TransactionTemplate transactionTemplate = new TransactionTemplate();
    transactionTemplate.setTransactionManager(transactionManager2);
    EventInsertRepository eventInsertRepository = new EventInsertRepository(mock(JdbcTemplate.class),
        transactionTemplate);

    // Act
    eventInsertRepository.save(new ArrayList<>());

    // Assert
    verify(transactionManager).getStatus();
  }

  /**
   * Test {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}.
   * <p>
   * Method under test: {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventInsertRepository.safePutString(PreparedStatement, int, String)"})
  public void testSafePutString() throws SQLException {
    // Arrange
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    EventInsertRepository eventInsertRepository = new EventInsertRepository(jdbcTemplate, new TransactionTemplate());
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    // Act
    eventInsertRepository.safePutString(ps, 1, "42");

    // Assert
    verify(ps).setString(eq(1), eq("42"));
  }

  /**
   * Test {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}.
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} does nothing.</li>
   *   <li>Then calls {@link PreparedStatement#setNull(int, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventInsertRepository.safePutString(PreparedStatement, int, String)"})
  public void testSafePutString_whenPreparedStatementSetNullDoesNothing_thenCallsSetNull() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setNull(anyInt(), anyInt());

    // Act
    eventInsertRepository.safePutString(ps, 1, null);

    // Assert
    verify(ps).setNull(eq(1), eq(12));
  }

  /**
   * Test {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}.
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventInsertRepository.safePutString(PreparedStatement, int, String)"})
  public void testSafePutString_whenPreparedStatementSetNullThrowRuntimeExceptionWithFoo() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new RuntimeException("foo")).when(ps).setNull(anyInt(), anyInt());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> eventInsertRepository.safePutString(ps, 1, null));
    verify(ps).setNull(eq(1), eq(12));
  }

  /**
   * Test {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}.
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setString(int, String)} does nothing.</li>
   *   <li>Then calls {@link PreparedStatement#setString(int, String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventInsertRepository.safePutString(PreparedStatement, int, String)"})
  public void testSafePutString_whenPreparedStatementSetStringDoesNothing_thenCallsSetString() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    // Act
    eventInsertRepository.safePutString(ps, 1, "42");

    // Assert
    verify(ps).setString(eq(1), eq("42"));
  }

  /**
   * Test {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}.
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setString(int, String)} throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventInsertRepository.safePutString(PreparedStatement, int, String)"})
  public void testSafePutString_whenPreparedStatementSetStringThrowRuntimeExceptionWithFoo() throws SQLException {
    // Arrange
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    EventInsertRepository eventInsertRepository = new EventInsertRepository(jdbcTemplate, new TransactionTemplate());
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new RuntimeException("foo")).when(ps).setString(anyInt(), Mockito.<String>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> eventInsertRepository.safePutString(ps, 1, "Value"));
    verify(ps).setString(eq(1), eq("Value"));
  }

  /**
   * Test {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}.
   * <p>
   * Method under test: {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventInsertRepository.safePutUUID(PreparedStatement, int, UUID)"})
  public void testSafePutUUID() throws SQLException {
    // Arrange
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    EventInsertRepository eventInsertRepository = new EventInsertRepository(jdbcTemplate, new TransactionTemplate());
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new RuntimeException("foo")).when(ps).setObject(anyInt(), Mockito.<Object>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> eventInsertRepository.safePutUUID(ps, 1, ModelConstants.NULL_UUID));
    verify(ps).setObject(eq(1), isA(Object.class));
  }

  /**
   * Test {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}.
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} does nothing.</li>
   *   <li>Then calls {@link PreparedStatement#setNull(int, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventInsertRepository.safePutUUID(PreparedStatement, int, UUID)"})
  public void testSafePutUUID_whenPreparedStatementSetNullDoesNothing_thenCallsSetNull() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setNull(anyInt(), anyInt());

    // Act
    eventInsertRepository.safePutUUID(ps, 1, null);

    // Assert
    verify(ps).setNull(eq(1), eq(1111));
  }

  /**
   * Test {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}.
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} throw {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventInsertRepository.safePutUUID(PreparedStatement, int, UUID)"})
  public void testSafePutUUID_whenPreparedStatementSetNullThrowRuntimeExceptionWithFoo() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new RuntimeException("foo")).when(ps).setNull(anyInt(), anyInt());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> eventInsertRepository.safePutUUID(ps, 1, null));
    verify(ps).setNull(eq(1), eq(1111));
  }

  /**
   * Test {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}.
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setObject(int, Object)} does nothing.</li>
   *   <li>Then calls {@link PreparedStatement#setObject(int, Object)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventInsertRepository.safePutUUID(PreparedStatement, int, UUID)"})
  public void testSafePutUUID_whenPreparedStatementSetObjectDoesNothing_thenCallsSetObject() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setObject(anyInt(), Mockito.<Object>any());

    // Act
    eventInsertRepository.safePutUUID(ps, 1, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(ps).setObject(eq(1), isA(Object.class));
  }
}
