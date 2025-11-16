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
package org.thingsboard.server.common.data.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ApiUsageLimitsExceededExceptionDiffblueTest {
  /**
   * Test {@link ApiUsageLimitsExceededException#ApiUsageLimitsExceededException(String)}.
   *
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ApiUsageLimitsExceededException#ApiUsageLimitsExceededException(String)}
   */
  @Test
  @DisplayName(
      "Test new ApiUsageLimitsExceededException(String); then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ApiUsageLimitsExceededException.<init>()",
    "void ApiUsageLimitsExceededException.<init>(String)"
  })
  void testNewApiUsageLimitsExceededException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    ApiUsageLimitsExceededException actualApiUsageLimitsExceededException =
        new ApiUsageLimitsExceededException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualApiUsageLimitsExceededException.getMessage());
    assertNull(actualApiUsageLimitsExceededException.getCause());
    assertEquals(0, actualApiUsageLimitsExceededException.getSuppressed().length);
  }

  /**
   * Test {@link ApiUsageLimitsExceededException#ApiUsageLimitsExceededException()}.
   *
   * <ul>
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitsExceededException#ApiUsageLimitsExceededException()}
   */
  @Test
  @DisplayName("Test new ApiUsageLimitsExceededException(); then return Message is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ApiUsageLimitsExceededException.<init>()",
    "void ApiUsageLimitsExceededException.<init>(String)"
  })
  void testNewApiUsageLimitsExceededException_thenReturnMessageIsNull() {
    // Arrange and Act
    ApiUsageLimitsExceededException actualApiUsageLimitsExceededException =
        new ApiUsageLimitsExceededException();

    // Assert
    assertNull(actualApiUsageLimitsExceededException.getMessage());
    assertNull(actualApiUsageLimitsExceededException.getCause());
    assertEquals(0, actualApiUsageLimitsExceededException.getSuppressed().length);
  }
}
