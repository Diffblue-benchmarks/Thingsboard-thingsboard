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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ApiFeatureDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiFeature#getApiStateKey()}
   *   <li>{@link ApiFeature#getLabel()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ApiFeature.getApiStateKey()", "String ApiFeature.getLabel()"})
  void testGettersAndSetters() {
    // Arrange
    ApiFeature valueOfResult = ApiFeature.valueOf("TRANSPORT");

    // Act
    String actualApiStateKey = valueOfResult.getApiStateKey();

    // Assert
    assertEquals("Device API", valueOfResult.getLabel());
    assertEquals("transportApiState", actualApiStateKey);
  }
}
