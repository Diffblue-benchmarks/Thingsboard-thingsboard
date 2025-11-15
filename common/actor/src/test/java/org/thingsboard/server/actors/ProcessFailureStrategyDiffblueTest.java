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
package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class ProcessFailureStrategyDiffblueTest {
  /**
   * Method under test: {@link ProcessFailureStrategy#stop()}
   */
  @Test
  void testStop() {
    // Arrange, Act and Assert
    assertTrue(ProcessFailureStrategy.stop().isStop());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ProcessFailureStrategy#toString()}
   *   <li>{@link ProcessFailureStrategy#isStop()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    ProcessFailureStrategy resumeResult = ProcessFailureStrategy.resume();

    // Act
    String actualToStringResult = resumeResult.toString();

    // Assert
    assertEquals("ProcessFailureStrategy(stop=false)", actualToStringResult);
    assertFalse(resumeResult.isStop());
  }

  /**
   * Method under test: {@link ProcessFailureStrategy#resume()}
   */
  @Test
  void testResume() {
    // Arrange, Act and Assert
    assertFalse(ProcessFailureStrategy.resume().isStop());
  }
}
