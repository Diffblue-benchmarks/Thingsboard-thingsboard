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
package org.thingsboard.server.queue.housekeeper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.housekeeper.HousekeeperTaskType;

class HousekeeperConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link HousekeeperConfig#getDisabledTaskTypes()}
   *   <li>{@link HousekeeperConfig#getMaxReprocessingAttempts()}
   *   <li>{@link HousekeeperConfig#getPollInterval()}
   *   <li>{@link HousekeeperConfig#getTaskProcessingTimeout()}
   *   <li>{@link HousekeeperConfig#getTaskReprocessingDelay()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    HousekeeperConfig housekeeperConfig = new HousekeeperConfig();

    // Act
    Set<HousekeeperTaskType> actualDisabledTaskTypes = housekeeperConfig.getDisabledTaskTypes();
    int actualMaxReprocessingAttempts = housekeeperConfig.getMaxReprocessingAttempts();
    int actualPollInterval = housekeeperConfig.getPollInterval();
    int actualTaskProcessingTimeout = housekeeperConfig.getTaskProcessingTimeout();

    // Assert
    assertNull(actualDisabledTaskTypes);
    assertEquals(0, actualMaxReprocessingAttempts);
    assertEquals(0, actualPollInterval);
    assertEquals(0, actualTaskProcessingTimeout);
    assertEquals(0, housekeeperConfig.getTaskReprocessingDelay());
  }
}
