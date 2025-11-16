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
package org.thingsboard.server.queue.azure.servicebus;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbServiceBusQueueConfigsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbServiceBusQueueConfigs#getCoreConfigs()}
   *   <li>{@link TbServiceBusQueueConfigs#getEdgeConfigs()}
   *   <li>{@link TbServiceBusQueueConfigs#getJsExecutorConfigs()}
   *   <li>{@link TbServiceBusQueueConfigs#getNotificationsConfigs()}
   *   <li>{@link TbServiceBusQueueConfigs#getRuleEngineConfigs()}
   *   <li>{@link TbServiceBusQueueConfigs#getTransportApiConfigs()}
   *   <li>{@link TbServiceBusQueueConfigs#getVcConfigs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map TbServiceBusQueueConfigs.getCoreConfigs()",
    "Map TbServiceBusQueueConfigs.getEdgeConfigs()",
    "Map TbServiceBusQueueConfigs.getJsExecutorConfigs()",
    "Map TbServiceBusQueueConfigs.getNotificationsConfigs()",
    "Map TbServiceBusQueueConfigs.getRuleEngineConfigs()",
    "Map TbServiceBusQueueConfigs.getTransportApiConfigs()",
    "Map TbServiceBusQueueConfigs.getVcConfigs()"
  })
  void testGettersAndSetters() {
    // Arrange
    TbServiceBusQueueConfigs tbServiceBusQueueConfigs = new TbServiceBusQueueConfigs();

    // Act
    Map<String, String> actualCoreConfigs = tbServiceBusQueueConfigs.getCoreConfigs();
    Map<String, String> actualEdgeConfigs = tbServiceBusQueueConfigs.getEdgeConfigs();
    Map<String, String> actualJsExecutorConfigs = tbServiceBusQueueConfigs.getJsExecutorConfigs();
    Map<String, String> actualNotificationsConfigs =
        tbServiceBusQueueConfigs.getNotificationsConfigs();
    Map<String, String> actualRuleEngineConfigs = tbServiceBusQueueConfigs.getRuleEngineConfigs();
    Map<String, String> actualTransportApiConfigs =
        tbServiceBusQueueConfigs.getTransportApiConfigs();

    // Assert
    assertNull(actualCoreConfigs);
    assertNull(actualEdgeConfigs);
    assertNull(actualJsExecutorConfigs);
    assertNull(actualNotificationsConfigs);
    assertNull(actualRuleEngineConfigs);
    assertNull(actualTransportApiConfigs);
    assertNull(tbServiceBusQueueConfigs.getVcConfigs());
  }
}
