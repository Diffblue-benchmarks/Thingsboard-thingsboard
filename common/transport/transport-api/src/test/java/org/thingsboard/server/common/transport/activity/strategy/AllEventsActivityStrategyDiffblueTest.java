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
package org.thingsboard.server.common.transport.activity.strategy;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AllEventsActivityStrategyDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Method under test: {@link AllEventsActivityStrategy#getInstance()}
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AllEventsActivityStrategy AllEventsActivityStrategy.getInstance()"})
  void testGettersAndSetters() {
    // Arrange and Act
    AllEventsActivityStrategy actualInstance = AllEventsActivityStrategy.getInstance();
    AllEventsActivityStrategy actualInstance2 = actualInstance.getInstance();

    // Assert
    assertSame(actualInstance, actualInstance2);
  }

  /**
   * Test {@link AllEventsActivityStrategy#onActivity()}.
   *
   * <p>Method under test: {@link AllEventsActivityStrategy#onActivity()}
   */
  @Test
  @DisplayName("Test onActivity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AllEventsActivityStrategy.onActivity()"})
  void testOnActivity() {
    // Arrange, Act and Assert
    assertTrue(AllEventsActivityStrategy.getInstance().onActivity());
  }

  /**
   * Test {@link AllEventsActivityStrategy#onReportingPeriodEnd()}.
   *
   * <p>Method under test: {@link AllEventsActivityStrategy#onReportingPeriodEnd()}
   */
  @Test
  @DisplayName("Test onReportingPeriodEnd()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AllEventsActivityStrategy.onReportingPeriodEnd()"})
  void testOnReportingPeriodEnd() {
    // Arrange, Act and Assert
    assertTrue(AllEventsActivityStrategy.getInstance().onReportingPeriodEnd());
  }
}
