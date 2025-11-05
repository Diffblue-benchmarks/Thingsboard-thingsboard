package org.thingsboard.server.dao.audit.sink;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.ExecutorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.audit.AuditLog;

@ExtendWith(MockitoExtension.class)
class ElasticsearchAuditLogSinkDiffblueTest {
  @InjectMocks private ElasticsearchAuditLogSink elasticsearchAuditLogSink;

  @Mock private ExecutorService executorService;

  /**
   * Test {@link ElasticsearchAuditLogSink#init()}.
   *
   * <p>Method under test: {@link ElasticsearchAuditLogSink#init()}
   */
  @Test
  @DisplayName("Test init()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElasticsearchAuditLogSink.init()"})
  void testInit() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> new ElasticsearchAuditLogSink().init());
  }

  /**
   * Test {@link ElasticsearchAuditLogSink#logAction(AuditLog)}.
   *
   * <ul>
   *   <li>Given {@link ExecutorService} {@link ExecutorService#execute(Runnable)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link ElasticsearchAuditLogSink#logAction(AuditLog)}
   */
  @Test
  @DisplayName("Test logAction(AuditLog); given ExecutorService execute(Runnable) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElasticsearchAuditLogSink.logAction(AuditLog)"})
  void testLogAction_givenExecutorServiceExecuteDoesNothing() {
    // Arrange
    doNothing().when(executorService).execute(Mockito.<Runnable>any());

    // Act
    elasticsearchAuditLogSink.logAction(new AuditLog());

    // Assert
    verify(executorService).execute(isA(Runnable.class));
  }

  /**
   * Test {@link ElasticsearchAuditLogSink#logAction(AuditLog)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link ElasticsearchAuditLogSink#logAction(AuditLog)}
   */
  @Test
  @DisplayName("Test logAction(AuditLog); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElasticsearchAuditLogSink.logAction(AuditLog)"})
  void testLogAction_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(executorService).execute(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> elasticsearchAuditLogSink.logAction(new AuditLog()));
    verify(executorService).execute(isA(Runnable.class));
  }
}
