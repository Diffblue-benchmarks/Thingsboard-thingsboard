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
package org.thingsboard.server.dao.audit.sink;

import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.concurrent.ExecutorService;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.audit.AuditLog;

@RunWith(MockitoJUnitRunner.class)
public class ElasticsearchAuditLogSinkDiffblueTest {
  @InjectMocks private ElasticsearchAuditLogSink elasticsearchAuditLogSink;

  @Mock private ExecutorService executorService;

  /**
   * Test {@link ElasticsearchAuditLogSink#init()}.
   *
   * <p>Method under test: {@link ElasticsearchAuditLogSink#init()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElasticsearchAuditLogSink.init()"})
  public void testInit() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElasticsearchAuditLogSink.logAction(AuditLog)"})
  public void testLogAction_givenExecutorServiceExecuteDoesNothing() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ElasticsearchAuditLogSink.logAction(AuditLog)"})
  public void testLogAction_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(executorService).execute(Mockito.<Runnable>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> elasticsearchAuditLogSink.logAction(new AuditLog()));
    verify(executorService).execute(isA(Runnable.class));
  }
}
