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
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.limit.LimitedApi;

class RateLimitExceededExceptionDiffblueTest {
  /**
   * Method under test:
   * {@link RateLimitExceededException#RateLimitExceededException(String)}
   */
  @Test
  void testNewRateLimitExceededException() {
    // Arrange and Act
    RateLimitExceededException actualRateLimitExceededException = new RateLimitExceededException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualRateLimitExceededException.getMessage());
    assertNull(actualRateLimitExceededException.getCause());
    assertEquals(0, actualRateLimitExceededException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link RateLimitExceededException#RateLimitExceededException(LimitedApi)}
   */
  @Test
  void testNewRateLimitExceededException2() {
    // Arrange and Act
    RateLimitExceededException actualRateLimitExceededException = new RateLimitExceededException(
        LimitedApi.ENTITY_EXPORT);

    // Assert
    assertEquals("Rate limit for entity version creation is exceeded",
        actualRateLimitExceededException.getLocalizedMessage());
    assertEquals("Rate limit for entity version creation is exceeded", actualRateLimitExceededException.getMessage());
    assertNull(actualRateLimitExceededException.getCause());
    assertEquals(0, actualRateLimitExceededException.getSuppressed().length);
  }
}
