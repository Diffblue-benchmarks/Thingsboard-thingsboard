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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LastEventActivityStrategyDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Method under test: {@link LastEventActivityStrategy#getInstance()}
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LastEventActivityStrategy LastEventActivityStrategy.getInstance()"})
  void testGettersAndSetters() {
    // Arrange and Act
    LastEventActivityStrategy actualInstance = LastEventActivityStrategy.getInstance();
    LastEventActivityStrategy actualInstance2 = actualInstance.getInstance();

    // Assert
    assertSame(actualInstance, actualInstance2);
  }

  /**
   * Test {@link LastEventActivityStrategy#onActivity()}.
   *
   * <p>Method under test: {@link LastEventActivityStrategy#onActivity()}
   */
  @Test
  @DisplayName("Test onActivity()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LastEventActivityStrategy.onActivity()"})
  void testOnActivity() {
    // Arrange, Act and Assert
    assertFalse(LastEventActivityStrategy.getInstance().onActivity());
  }

  /**
   * Test {@link LastEventActivityStrategy#onReportingPeriodEnd()}.
   *
   * <p>Method under test: {@link LastEventActivityStrategy#onReportingPeriodEnd()}
   */
  @Test
  @DisplayName("Test onReportingPeriodEnd()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean LastEventActivityStrategy.onReportingPeriodEnd()"})
  void testOnReportingPeriodEnd() {
    // Arrange, Act and Assert
    assertTrue(LastEventActivityStrategy.getInstance().onReportingPeriodEnd());
  }
}
