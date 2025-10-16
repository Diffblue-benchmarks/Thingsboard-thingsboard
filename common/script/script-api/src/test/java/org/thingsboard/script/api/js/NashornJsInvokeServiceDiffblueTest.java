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
package org.thingsboard.script.api.js;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.stats.TbApiUsageReportClient;
import org.thingsboard.server.common.stats.TbApiUsageStateClient;

class NashornJsInvokeServiceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NashornJsInvokeService#getMaxBlackListDurationSec()}
   *   <li>{@link NashornJsInvokeService#getMaxErrors()}
   *   <li>{@link NashornJsInvokeService#getMaxInvokeRequestsTimeout()}
   *   <li>{@link NashornJsInvokeService#getStatsName()}
   *   <li>{@link NashornJsInvokeService#isStatsEnabled()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int NashornJsInvokeService.getMaxBlackListDurationSec()",
    "int NashornJsInvokeService.getMaxErrors()",
    "long NashornJsInvokeService.getMaxInvokeRequestsTimeout()",
    "String NashornJsInvokeService.getStatsName()",
    "boolean NashornJsInvokeService.isStatsEnabled()"
  })
  void testGettersAndSetters() {
    // Arrange
    Optional<TbApiUsageStateClient> apiUsageStateClient =
        Optional.of(mock(TbApiUsageStateClient.class));
    Optional<TbApiUsageReportClient> apiUsageReportClient =
        Optional.of(mock(TbApiUsageReportClient.class));

    NashornJsInvokeService nashornJsInvokeService =
        new NashornJsInvokeService(apiUsageStateClient, apiUsageReportClient);

    // Act
    int actualMaxBlackListDurationSec = nashornJsInvokeService.getMaxBlackListDurationSec();
    int actualMaxErrors = nashornJsInvokeService.getMaxErrors();
    long actualMaxInvokeRequestsTimeout = nashornJsInvokeService.getMaxInvokeRequestsTimeout();
    String actualStatsName = nashornJsInvokeService.getStatsName();

    // Assert
    assertEquals("Nashorn JS Invoke Stats", actualStatsName);
    assertEquals(0, actualMaxBlackListDurationSec);
    assertEquals(0, actualMaxErrors);
    assertEquals(0L, actualMaxInvokeRequestsTimeout);
    assertFalse(nashornJsInvokeService.isStatsEnabled());
  }
}
