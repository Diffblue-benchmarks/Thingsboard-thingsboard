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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
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
import org.thingsboard.server.common.data.event.ErrorEvent;
import org.thingsboard.server.common.data.event.Event;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {EventInsertRepository.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class EventInsertRepositoryDiffblueTest {
  @Autowired private EventInsertRepository eventInsertRepository;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link EventInsertRepository#save(List)}.
   *
   * <p>Method under test: {@link EventInsertRepository#save(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventInsertRepository.save(List)"})
  public void testSave() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenReturn("Execute");

    ArrayList<Event> entities = new ArrayList<>();
    entities.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    // Act
    eventInsertRepository.save(entities);

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }

  /**
   * Test {@link EventInsertRepository#save(List)}.
   *
   * <p>Method under test: {@link EventInsertRepository#save(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventInsertRepository.save(List)"})
  public void testSave2() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenReturn("Execute");

    ArrayList<Event> entities = new ArrayList<>();
    entities.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());
    entities.add(
        ErrorEvent.builder()
            .entityId(ModelConstants.NULL_UUID)
            .error("An error occurred")
            .id(ModelConstants.NULL_UUID)
            .method("Method")
            .serviceId("42")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .ts(1L)
            .build());

    // Act
    eventInsertRepository.save(entities);

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }

  /**
   * Test {@link EventInsertRepository#save(List)}.
   *
   * <ul>
   *   <li>Given {@link TransactionManager} {@link TransactionManager#getStatus()} return one.
   *   <li>Then calls {@link TransactionManager#getStatus()}.
   * </ul>
   *
   * <p>Method under test: {@link EventInsertRepository#save(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventInsertRepository.save(List)"})
  public void testSave_givenTransactionManagerGetStatusReturnOne_thenCallsGetStatus()
      throws SystemException {
    // Arrange
    TransactionManager transactionManager = mock(TransactionManager.class);
    when(transactionManager.getStatus()).thenReturn(1);
    JtaTransactionManager transactionManager2 = new JtaTransactionManager(transactionManager);
    TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager2);
    EventInsertRepository eventInsertRepository =
        new EventInsertRepository(mock(JdbcTemplate.class), transactionTemplate);

    // Act
    eventInsertRepository.save(new ArrayList<>());

    // Assert
    verify(transactionManager).getStatus();
  }

  /**
   * Test {@link EventInsertRepository#save(List)}.
   *
   * <ul>
   *   <li>Given {@link TransactionTemplate} {@link
   *       TransactionTemplate#execute(TransactionCallback)} return {@code Execute}.
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link EventInsertRepository#save(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventInsertRepository.save(List)"})
  public void testSave_givenTransactionTemplateExecuteReturnExecute_whenArrayList()
      throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenReturn("Execute");

    // Act
    eventInsertRepository.save(new ArrayList<>());

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }

  /**
   * Test {@link EventInsertRepository#save(List)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link EventInsertRepository#save(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventInsertRepository.save(List)"})
  public void testSave_thenThrowRuntimeException() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any()))
        .thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> eventInsertRepository.save(new ArrayList<>()));
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }

  /**
   * Test {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}.
   *
   * <p>Method under test: {@link EventInsertRepository#safePutString(PreparedStatement, int,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventInsertRepository.safePutString(PreparedStatement, int, String)"})
  public void testSafePutString() throws SQLException {
    // Arrange
    JdbcTemplate jdbcTemplate = mock(JdbcTemplate.class);
    EventInsertRepository eventInsertRepository =
        new EventInsertRepository(jdbcTemplate, new TransactionTemplate());

    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    // Act
    eventInsertRepository.safePutString(ps, 1, "42");

    // Assert
    verify(ps).setString(1, "42");
  }

  /**
   * Test {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} does nothing.
   *   <li>Then calls {@link PreparedStatement#setNull(int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link EventInsertRepository#safePutString(PreparedStatement, int,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventInsertRepository.safePutString(PreparedStatement, int, String)"})
  public void testSafePutString_whenPreparedStatementSetNullDoesNothing_thenCallsSetNull()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setNull(anyInt(), anyInt());

    // Act
    eventInsertRepository.safePutString(ps, 1, null);

    // Assert
    verify(ps).setNull(1, 12);
  }

  /**
   * Test {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EventInsertRepository#safePutString(PreparedStatement, int,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventInsertRepository.safePutString(PreparedStatement, int, String)"})
  public void testSafePutString_whenPreparedStatementSetNullThrowRuntimeException()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new RuntimeException()).when(ps).setNull(anyInt(), anyInt());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> eventInsertRepository.safePutString(ps, 1, null));
    verify(ps).setNull(1, 12);
  }

  /**
   * Test {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setString(int, String)} does
   *       nothing.
   *   <li>Then calls {@link PreparedStatement#setString(int, String)}.
   * </ul>
   *
   * <p>Method under test: {@link EventInsertRepository#safePutString(PreparedStatement, int,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventInsertRepository.safePutString(PreparedStatement, int, String)"})
  public void testSafePutString_whenPreparedStatementSetStringDoesNothing_thenCallsSetString()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    // Act
    eventInsertRepository.safePutString(ps, 1, "42");

    // Assert
    verify(ps).setString(1, "42");
  }

  /**
   * Test {@link EventInsertRepository#safePutString(PreparedStatement, int, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setString(int, String)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EventInsertRepository#safePutString(PreparedStatement, int,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventInsertRepository.safePutString(PreparedStatement, int, String)"})
  public void testSafePutString_whenPreparedStatementSetStringThrowRuntimeException()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new RuntimeException()).when(ps).setString(anyInt(), Mockito.<String>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> eventInsertRepository.safePutString(ps, 1, "42"));
    verify(ps).setString(1, "42");
  }

  /**
   * Test {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} does nothing.
   *   <li>Then calls {@link PreparedStatement#setNull(int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventInsertRepository.safePutUUID(PreparedStatement, int, UUID)"})
  public void testSafePutUUID_whenPreparedStatementSetNullDoesNothing_thenCallsSetNull()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setNull(anyInt(), anyInt());

    // Act
    eventInsertRepository.safePutUUID(ps, 1, null);

    // Assert
    verify(ps).setNull(1, 1111);
  }

  /**
   * Test {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventInsertRepository.safePutUUID(PreparedStatement, int, UUID)"})
  public void testSafePutUUID_whenPreparedStatementSetNullThrowRuntimeException()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new RuntimeException()).when(ps).setNull(anyInt(), anyInt());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> eventInsertRepository.safePutUUID(ps, 1, null));
    verify(ps).setNull(1, 1111);
  }

  /**
   * Test {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setObject(int, Object)} does
   *       nothing.
   *   <li>Then calls {@link PreparedStatement#setObject(int, Object)}.
   * </ul>
   *
   * <p>Method under test: {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventInsertRepository.safePutUUID(PreparedStatement, int, UUID)"})
  public void testSafePutUUID_whenPreparedStatementSetObjectDoesNothing_thenCallsSetObject()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setObject(anyInt(), Mockito.<Object>any());

    // Act
    eventInsertRepository.safePutUUID(ps, 1, ModelConstants.NULL_UUID);

    // Assert
    verify(ps).setObject(eq(1), isA(Object.class));
  }

  /**
   * Test {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setObject(int, Object)} throw
   *       {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EventInsertRepository#safePutUUID(PreparedStatement, int, UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventInsertRepository.safePutUUID(PreparedStatement, int, UUID)"})
  public void testSafePutUUID_whenPreparedStatementSetObjectThrowRuntimeException()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new RuntimeException()).when(ps).setObject(anyInt(), Mockito.<Object>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> eventInsertRepository.safePutUUID(ps, 1, ModelConstants.NULL_UUID));
    verify(ps).setObject(eq(1), isA(Object.class));
  }
}
