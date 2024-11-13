package org.thingsboard.server.dao.cassandra.guava;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.datastax.dse.driver.internal.core.session.DefaultDseSession;
import com.datastax.oss.driver.api.core.cql.AsyncResultSet;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.session.Session;
import com.datastax.oss.driver.api.core.type.reflect.GenericType;
import com.datastax.oss.driver.internal.core.cql.DefaultPrepareRequest;
import com.datastax.oss.driver.internal.core.cql.DefaultSimpleStatement;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GuavaSessionDiffblueTest {
  /**
   * Test {@link GuavaSession#executeAsync(String)} with {@code String}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GuavaSession#executeAsync(String)}
   */
  @Test
  @DisplayName("Test executeAsync(String) with 'String'; then return SettableFuture")
  void testExecuteAsyncWithString_thenReturnSettableFuture() {
    // Arrange
    Session delegate = mock(Session.class);
    SettableFuture<AsyncResultSet> createResult = SettableFuture.create();
    when(delegate.execute(Mockito.<DefaultSimpleStatement>any(),
        Mockito.<GenericType<ListenableFuture<AsyncResultSet>>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<AsyncResultSet> actualExecuteAsyncResult = (new DefaultGuavaSession(
        new DefaultDseSession(delegate))).executeAsync("MD");

    // Assert
    verify(delegate).execute(isA(DefaultSimpleStatement.class), isA(GenericType.class));
    assertTrue(actualExecuteAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualExecuteAsyncResult);
  }

  /**
   * Test {@link GuavaSession#prepareAsync(String)} with {@code String}.
   * <ul>
   *   <li>Then return {@link SettableFuture}.</li>
   * </ul>
   * <p>
   * Method under test: {@link GuavaSession#prepareAsync(String)}
   */
  @Test
  @DisplayName("Test prepareAsync(String) with 'String'; then return SettableFuture")
  void testPrepareAsyncWithString_thenReturnSettableFuture() {
    // Arrange
    Session delegate = mock(Session.class);
    SettableFuture<PreparedStatement> createResult = SettableFuture.create();
    when(delegate.execute(Mockito.<DefaultPrepareRequest>any(),
        Mockito.<GenericType<ListenableFuture<PreparedStatement>>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<PreparedStatement> actualPrepareAsyncResult = (new DefaultGuavaSession(
        new DefaultDseSession(delegate))).prepareAsync("MD");

    // Assert
    verify(delegate).execute(isA(DefaultPrepareRequest.class), isA(GenericType.class));
    assertTrue(actualPrepareAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualPrepareAsyncResult);
  }
}
