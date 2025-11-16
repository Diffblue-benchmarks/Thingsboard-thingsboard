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
package org.thingsboard.monitoring.data.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.monitoring.data.Latency;

class HighLatencyNotificationDiffblueTest {
  /**
   * Test {@link HighLatencyNotification#HighLatencyNotification(Collection, int)}.
   *
   * <p>Method under test: {@link HighLatencyNotification#HighLatencyNotification(Collection, int)}
   */
  @Test
  @DisplayName("Test new HighLatencyNotification(Collection, int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void HighLatencyNotification.<init>(Collection, int)"})
  void testNewHighLatencyNotification() {
    // Arrange, Act and Assert
    assertEquals(
        "Some of the latencies are higher than 1 ms:\n",
        new HighLatencyNotification(new ArrayList<>(), 1).getText());
  }

  /**
   * Test {@link HighLatencyNotification#getText()}.
   *
   * <p>Method under test: {@link HighLatencyNotification#getText()}
   */
  @Test
  @DisplayName("Test getText()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String HighLatencyNotification.getText()"})
  void testGetText() {
    // Arrange
    ArrayList<Latency> highLatencies = new ArrayList<>();
    highLatencies.add(Latency.of("Some of the latencies are higher than ", 10.0d));

    // Act and Assert
    assertEquals(
        "Some of the latencies are higher than 1 ms:\n[Some of the latencies are higher than ] *10.00 ms*\n",
        new HighLatencyNotification(highLatencies, 1).getText());
  }

  /**
   * Test {@link HighLatencyNotification#getText()}.
   *
   * <ul>
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link HighLatencyNotification#getText()}
   */
  @Test
  @DisplayName("Test getText(); then return a string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String HighLatencyNotification.getText()"})
  void testGetText_thenReturnAString() {
    // Arrange
    ArrayList<Latency> highLatencies = new ArrayList<>();
    highLatencies.add(Latency.of("Some of the latencies are higher than ", 10.0d));
    highLatencies.add(Latency.of("Some of the latencies are higher than ", 10.0d));

    // Act and Assert
    assertEquals(
        "Some of the latencies are higher than 1 ms:\n"
            + "[Some of the latencies are higher than ] *10.00 ms*\n"
            + "[Some of the latencies are higher than ] *10.00 ms*\n",
        new HighLatencyNotification(highLatencies, 1).getText());
  }

  /**
   * Test {@link HighLatencyNotification#getText()}.
   *
   * <ul>
   *   <li>Then return {@code Some of the latencies are higher than 1 ms:}.
   * </ul>
   *
   * <p>Method under test: {@link HighLatencyNotification#getText()}
   */
  @Test
  @DisplayName("Test getText(); then return 'Some of the latencies are higher than 1 ms:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String HighLatencyNotification.getText()"})
  void testGetText_thenReturnSomeOfTheLatenciesAreHigherThan1Ms() {
    // Arrange, Act and Assert
    assertEquals(
        "Some of the latencies are higher than 1 ms:\n",
        new HighLatencyNotification(new ArrayList<>(), 1).getText());
  }
}
