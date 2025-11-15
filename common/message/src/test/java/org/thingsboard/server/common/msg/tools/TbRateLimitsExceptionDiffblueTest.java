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
package org.thingsboard.server.common.msg.tools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class TbRateLimitsExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbRateLimitsException#TbRateLimitsException(String)}
   *   <li>{@link TbRateLimitsException#getEntityType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TbRateLimitsException actualTbRateLimitsException = new TbRateLimitsException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualTbRateLimitsException.getMessage());
    assertNull(actualTbRateLimitsException.getCause());
    assertNull(actualTbRateLimitsException.getEntityType());
    assertEquals(0, actualTbRateLimitsException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link TbRateLimitsException#TbRateLimitsException(EntityType)}
   */
  @Test
  void testNewTbRateLimitsException() {
    // Arrange and Act
    TbRateLimitsException actualTbRateLimitsException = new TbRateLimitsException(EntityType.TENANT);

    // Assert
    assertEquals("TENANT rate limits reached!", actualTbRateLimitsException.getLocalizedMessage());
    assertEquals("TENANT rate limits reached!", actualTbRateLimitsException.getMessage());
    assertNull(actualTbRateLimitsException.getCause());
    assertEquals(0, actualTbRateLimitsException.getSuppressed().length);
    assertEquals(EntityType.TENANT, actualTbRateLimitsException.getEntityType());
  }
}
