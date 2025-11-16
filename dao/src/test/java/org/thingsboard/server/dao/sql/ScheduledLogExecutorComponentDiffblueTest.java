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
package org.thingsboard.server.dao.sql;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ScheduledLogExecutorComponentDiffblueTest {
  @Mock private ScheduledExecutorService scheduledExecutorService;

  @InjectMocks private ScheduledLogExecutorComponent scheduledLogExecutorComponent;

  /**
   * Test {@link ScheduledLogExecutorComponent#stop()}.
   *
   * <p>Method under test: {@link ScheduledLogExecutorComponent#stop()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScheduledLogExecutorComponent.stop()"})
  public void testStop() {
    // Arrange
    when(scheduledExecutorService.shutdownNow()).thenReturn(new ArrayList<>());

    // Act
    scheduledLogExecutorComponent.stop();

    // Assert
    verify(scheduledExecutorService).shutdownNow();
  }

  /**
   * Test {@link ScheduledLogExecutorComponent#scheduleAtFixedRate(Runnable, long, long, TimeUnit)}.
   *
   * <p>Method under test: {@link ScheduledLogExecutorComponent#scheduleAtFixedRate(Runnable, long,
   * long, TimeUnit)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ScheduledLogExecutorComponent.scheduleAtFixedRate(Runnable, long, long, TimeUnit)"
  })
  public void testScheduleAtFixedRate() {
    // Arrange
    Mockito.<ScheduledFuture<?>>when(
            scheduledExecutorService.scheduleAtFixedRate(
                Mockito.<Runnable>any(), anyLong(), anyLong(), Mockito.<TimeUnit>any()))
        .thenReturn(null);

    // Act
    scheduledLogExecutorComponent.scheduleAtFixedRate(
        mock(Runnable.class), 1L, 1L, TimeUnit.NANOSECONDS);

    // Assert
    verify(scheduledExecutorService)
        .scheduleAtFixedRate(isA(Runnable.class), eq(1L), eq(1L), eq(TimeUnit.NANOSECONDS));
  }
}
