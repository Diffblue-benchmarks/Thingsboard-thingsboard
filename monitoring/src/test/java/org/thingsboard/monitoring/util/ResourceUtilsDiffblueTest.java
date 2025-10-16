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
package org.thingsboard.monitoring.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ResourceUtilsDiffblueTest {
  /**
   * Test {@link ResourceUtils#getResource(String, Class)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getResource(String, Class)}
   */
  @Test
  @DisplayName("Test getResource(String, Class); when 'Path'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object ResourceUtils.getResource(String, Class)"})
  void testGetResource_whenPath_thenThrowIllegalArgumentException() {
    // Arrange
    Class<Object> type = Object.class;

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ResourceUtils.getResource("Path", type));
  }

  /**
   * Test {@link ResourceUtils#getResourceAsStream(String)}.
   *
   * <ul>
   *   <li>When {@code Path}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link ResourceUtils#getResourceAsStream(String)}
   */
  @Test
  @DisplayName("Test getResourceAsStream(String); when 'Path'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.io.InputStream ResourceUtils.getResourceAsStream(String)"})
  void testGetResourceAsStream_whenPath_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> ResourceUtils.getResourceAsStream("Path"));
  }
}
