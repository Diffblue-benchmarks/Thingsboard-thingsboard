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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
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
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.event.Event;
import org.thingsboard.server.common.data.event.EventType;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {EventInsertRepository.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
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
   *   <li>Given {@link Event} {@link Event#getType()} return {@code ERROR}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Event}.</li>
   *   <li>Then calls {@link Event#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventInsertRepository#save(List)}
   */
  @Test
  public void testSave_givenEventGetTypeReturnError_whenArrayListAddEvent_thenCallsGetType()
      throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn("Execute");
    Event event = mock(Event.class);
    when(event.getType()).thenReturn(EventType.ERROR);

    ArrayList<Event> entities = new ArrayList<>();
    entities.add(event);

    // Act
    eventInsertRepository.save(entities);

    // Assert that nothing has changed
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    verify(event).getType();
  }

  /**
   * Test {@link EventInsertRepository#save(List)}.
   * <ul>
   *   <li>Given {@link Event} {@link Event#getType()} return {@code ERROR}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@link Event}.</li>
   *   <li>Then calls {@link Event#getType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventInsertRepository#save(List)}
   */
  @Test
  public void testSave_givenEventGetTypeReturnError_whenArrayListAddEvent_thenCallsGetType2()
      throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn("Execute");
    Event event = mock(Event.class);
    when(event.getType()).thenReturn(EventType.ERROR);
    Event event2 = mock(Event.class);
    when(event2.getType()).thenReturn(EventType.ERROR);

    ArrayList<Event> entities = new ArrayList<>();
    entities.add(event2);
    entities.add(event);

    // Act
    eventInsertRepository.save(entities);

    // Assert that nothing has changed
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    verify(event2).getType();
    verify(event).getType();
  }

  /**
   * Test {@link EventInsertRepository#save(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EventInsertRepository#save(List)}
   */
  @Test
  public void testSave_whenArrayList() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn("Execute");

    // Act
    eventInsertRepository.save(new ArrayList<>());

    // Assert that nothing has changed
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }

  /**
   * Test
   * {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}
   */
  @Test
  public void testSafePutString_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new RuntimeException("foo")).when(ps).setNull(anyInt(), anyInt());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> eventInsertRepository.safePutString(ps, 1, null));
    verify(ps).setNull(eq(1), eq(12));
  }

  /**
   * Test
   * {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}.
   * <ul>
   *   <li>When {@link PreparedStatement}
   * {@link PreparedStatement#setNull(int, int)} does nothing.</li>
   *   <li>Then calls {@link PreparedStatement#setNull(int, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}
   */
  @Test
  public void testSafePutString_whenPreparedStatementSetNullDoesNothing_thenCallsSetNull() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setNull(anyInt(), anyInt());

    // Act
    eventInsertRepository.safePutString(ps, 1, null);

    // Assert that nothing has changed
    verify(ps).setNull(eq(1), eq(12));
  }

  /**
   * Test
   * {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}.
   * <ul>
   *   <li>When {@link PreparedStatement}
   * {@link PreparedStatement#setString(int, String)} does nothing.</li>
   *   <li>Then calls {@link PreparedStatement#setString(int, String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}
   */
  @Test
  public void testSafePutString_whenPreparedStatementSetStringDoesNothing_thenCallsSetString() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    // Act
    eventInsertRepository.safePutString(ps, 1, "42");

    // Assert that nothing has changed
    verify(ps).setString(eq(1), eq("42"));
  }

  /**
   * Test {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with
   * {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}
   */
  @Test
  public void testSafePutUUID_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() throws SQLException {
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
   *   <li>When {@link PreparedStatement}
   * {@link PreparedStatement#setNull(int, int)} does nothing.</li>
   *   <li>Then calls {@link PreparedStatement#setNull(int, int)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}
   */
  @Test
  public void testSafePutUUID_whenPreparedStatementSetNullDoesNothing_thenCallsSetNull() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setNull(anyInt(), anyInt());

    // Act
    eventInsertRepository.safePutUUID(ps, 1, null);

    // Assert that nothing has changed
    verify(ps).setNull(eq(1), eq(1111));
  }

  /**
   * Test {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}.
   * <ul>
   *   <li>When {@link PreparedStatement}
   * {@link PreparedStatement#setObject(int, Object)} does nothing.</li>
   *   <li>Then calls {@link PreparedStatement#setObject(int, Object)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}
   */
  @Test
  public void testSafePutUUID_whenPreparedStatementSetObjectDoesNothing_thenCallsSetObject() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setObject(anyInt(), Mockito.<Object>any());

    // Act
    eventInsertRepository.safePutUUID(ps, 1, ModelConstants.NULL_UUID);

    // Assert that nothing has changed
    verify(ps).setObject(eq(1), isA(Object.class));
  }
}
