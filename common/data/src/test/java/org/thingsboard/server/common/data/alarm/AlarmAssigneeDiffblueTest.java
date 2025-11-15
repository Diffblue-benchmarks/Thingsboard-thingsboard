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
package org.thingsboard.server.common.data.alarm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AlarmAssigneeDiffblueTest {
  /**
   * Test {@link AlarmAssignee#getTitle()}.
   * <ul>
   *   <li>Then return {@code Doe}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmAssignee#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); then return 'Doe'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmAssignee.getTitle()"})
  void testGetTitle_thenReturnDoe() {
    // Arrange, Act and Assert
    assertEquals("Doe", (new AlarmAssignee(null, "", "Doe", "jane.doe@example.org")).getTitle());
  }

  /**
   * Test {@link AlarmAssignee#getTitle()}.
   * <ul>
   *   <li>Then return {@code Jane}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmAssignee#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); then return 'Jane'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmAssignee.getTitle()"})
  void testGetTitle_thenReturnJane() {
    // Arrange, Act and Assert
    assertEquals("Jane", (new AlarmAssignee(null, "Jane", "", "jane.doe@example.org")).getTitle());
  }

  /**
   * Test {@link AlarmAssignee#getTitle()}.
   * <ul>
   *   <li>Then return {@code Jane Doe}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmAssignee#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); then return 'Jane Doe'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmAssignee.getTitle()"})
  void testGetTitle_thenReturnJaneDoe() {
    // Arrange, Act and Assert
    assertEquals("Jane Doe", (new AlarmAssignee(null, "Jane", "Doe", "jane.doe@example.org")).getTitle());
  }

  /**
   * Test {@link AlarmAssignee#getTitle()}.
   * <ul>
   *   <li>Then return {@code jane.doe@example.org}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AlarmAssignee#getTitle()}
   */
  @Test
  @DisplayName("Test getTitle(); then return 'jane.doe@example.org'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String AlarmAssignee.getTitle()"})
  void testGetTitle_thenReturnJaneDoeExampleOrg() {
    // Arrange, Act and Assert
    assertEquals("jane.doe@example.org", (new AlarmAssignee(null, "", "", "jane.doe@example.org")).getTitle());
  }
}
